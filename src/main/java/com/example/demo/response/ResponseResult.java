package com.example.demo.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

// @ControllerAdvice：作用：对所有控制器中，被@RequestMapping注解标注的方法，进行增强（也可以直接使用@RestControllerAdvice）
@RestControllerAdvice(basePackages  = "com.example.demo.api")   // 控制器类增强：可以对Controller中所有使用@RequestMapping注解的方法增强
public class ResponseResult<T> implements ResponseBodyAdvice<Object> {
    private static final Logger logger = Logger.getLogger(ResponseResult.class);

    /**被拦截的响应，立即执行该方法。
     * body ：是请求控制器方法接口后，响应的内容。（其他参数不用了解）
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {

        // String类型不能直接包装
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            // 将数据包装在ResultVo里后转换为json串进行返回
            try {
                return objectMapper.writeValueAsString(ResponseData.success(body));
            } catch (JsonProcessingException e) {
                // 这里正常应该加如自定义的统一异常处理
                logger.error("系统错误",e);
            }
        }
//        else if(body instanceof ExceptionResponseResult) {// 判断返回值结果是否是一个异常对象类型
//                         // 如果是异常类型，传入异常状态码（枚举类型）和异常数据。
//                         return ResponseData.error(ResponseCode.SYSTEM_ERROR,body);
//        }
        return ResponseData.success(body);
    }

    /**
     * 这个方法的返回值，决定是否启动结果响应拦截，当返回为true是，表示拦截
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseData errorHandler(Exception ex) {
        logger.error(ex);
        return ResponseData.error(ResponseCode.SYSTEM_ERROR,ex.getMessage());
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public ResponseData myErrorHandler(MyException ex) {
        logger.error(ex);
        return  ResponseData.generator(ex.getCode(),ex.getMessage(),ex.getMessage());
    }

}
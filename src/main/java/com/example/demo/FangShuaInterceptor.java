package com.example.demo;


import com.example.demo.annotation.AccessLimit;
import com.example.demo.response.UserVo;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * FangShuaInterceptor
 *
 * @author: niko
 * @date: 2022/9/5 16:16
 */
@Component
public class FangShuaInterceptor implements HandlerInterceptor {
    private static final Logger logger = Logger.getLogger(FangShuaInterceptor.class);
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler;
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if(accessLimit==null){
                return true;
            }
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean login = accessLimit.needLogin();
            String key = request.getRequestURI();
            //如果需要登录
            if(login){
                // 获取登录的session进行判断。。。
                HttpSession session = request.getSession();
//                UserVo user  = (UserVo) session.getAttribute("USER_SESSION");
//                if(user == null){
//                    return false;
//                }
                key+=""+"1"; //假设用户id是1 实际是需要动态获取
            }
            key ="User:login"+key;
            if(!redisTemplate.hasKey(key)){
                redisTemplate.opsForValue().set(key,"1");
                redisTemplate.expire(key,seconds, TimeUnit.SECONDS);//一分钟过期
            }else {
                redisTemplate.opsForValue().increment(key,1);

            }
            logger.info("---->"+redisTemplate.opsForValue().get(key));
            Integer count = Integer.valueOf((String)redisTemplate.opsForValue().get(key));
            if(count<maxCount){
                //加1次 上面已经加了这里就不加了
            }else{
                //超出访问次数
                render(response,"超出访问次数"); //这里的CodeMsg是一个返回参数
                return false;
            }

            //从redis 中获取用户访问的次数

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private void render(HttpServletResponse response, String cm)throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        out.write(cm.getBytes("UTF-8"));
        out.flush();
        out.close();
    }
}

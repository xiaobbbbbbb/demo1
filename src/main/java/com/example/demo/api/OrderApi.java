package com.example.demo.api;

import com.example.demo.requsetVo.TestVo;
import com.example.demo.response.MyException;
import com.example.demo.response.ResponseData;
import com.example.demo.response.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "订单接口")
@RestController
@RequestMapping("/order")
public class OrderApi {
    private static final Logger logger =Logger.getLogger (OrderApi.class);

    @ApiOperation(value="获取订单信息", notes="订单", produces="application/json")
//    @ApiImplicitParam(name = "id", value = "订单id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value="/getInfo/{id}",  method= RequestMethod.POST)
    public ResponseData getOrderInfo(@RequestBody TestVo testVo, @PathVariable String id){
        return  ResponseData.generator(10086,"system error",null);
    }

    @ApiOperation(value="用户信息", notes="用户", produces="application/json")
//    @ApiImplicitParam(name = "id", value = "订单id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value="/getUser/{id}",  method= RequestMethod.POST)
    public ResponseData<UserVo> getUser(@RequestBody TestVo testVo, @PathVariable String id){
        UserVo userVo = new UserVo();
        userVo.setUserId("xxx-0ss");
        userVo.setUserName("lilith");
        ResponseData<UserVo> responseData = ResponseData.success(userVo);
        return responseData;
    }

    @ApiOperation(value="查询所有订单", notes="订单", produces="application/json")
    @PostMapping(value = "/findOrders")
    public UserVo findOrders(@RequestBody String body) throws Exception {
        UserVo userVo = new UserVo();
        userVo.setUserId("xxx-0ss");
        userVo.setUserName("lilith");
        if(1==1){
            throw new MyException(123123,"查询订单失败");
        }
        return userVo;

    }
}

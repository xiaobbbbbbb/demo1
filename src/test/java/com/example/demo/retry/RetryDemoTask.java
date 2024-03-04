package com.example.demo.retry;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * RetryDemoTask
 *
 * @author: niko
 * @date: 2022/9/7 15:40
 */
@Slf4j
public class RetryDemoTask {

    /**
     * 重试方法
     * @param param
     * @return
     */
    public static boolean retryTask(String param){
        log.info("请求参数:{}",param);
        int i = RandomUtil.randomInt(0,10);
        log.info("随机生成的数为:{}",i);
        if (i == 0) {
            log.info("为0,抛出参数异常.");
            throw new IllegalArgumentException("参数异常");
        }else if (i  == 1){
            log.info("为1,返回true.");
            return true;
        }else if (i == 2){
            log.info("为2,返回false.");
            return false;
        }else{
            //为其他
            log.info("大于2,抛出自定义异常.");
            throw new NullPointerException("大于2,抛出运行时异常");
        }
    }


}

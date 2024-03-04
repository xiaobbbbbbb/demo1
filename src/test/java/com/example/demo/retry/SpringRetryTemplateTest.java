package com.example.demo.retry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * SpringRetryTemplateTest
 *
 * @author: niko
 * @date: 2022/9/7 15:59
 */
@Slf4j
public class SpringRetryTemplateTest {
    /**
     * 重试间隔时间ms,默认1000ms
     * */
    private long fixedPeriodTime = 3000L;
    /**
     * 最大重试次数,默认为3
     */
    private int maxRetryTimes = 2;
    /**
     * 表示哪些异常需要重试,key表示异常的字节码,value为true表示需要重试
     */
    private Map<Class<? extends Throwable>, Boolean> exceptionMap = new HashMap<>();

    private static Boolean doWithRetry(RetryContext retryContext) {
        boolean b = RetryDemoTask.retryTask("123");
        log.info("返回的结果:{}", b);
        return b;
    }

    @Test
    public void test(){
        exceptionMap.put(NullPointerException.class,true);

        // 构建重试模板实例
        RetryTemplate retryTemplate = new RetryTemplate();

        // 设置重试回退操作策略，主要设置重试间隔时间
        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(fixedPeriodTime);

        // 设置重试策略，主要设置重试次数
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(maxRetryTimes, exceptionMap);
        retryTemplate.setBackOffPolicy(backOffPolicy);
        retryTemplate.setRetryPolicy(retryPolicy);
        boolean execute= retryTemplate.execute(SpringRetryTemplateTest::doWithRetry,
            retryContext -> {
                //RecoveryCallback
                log.info("已达到最大重试次数或抛出了不重试的异常~~~");
                return false;
            }
        );
        log.info("执行结果--->{}",execute);
    }




}

class Car{

    private static Car create(final Supplier<Car> carSupplier){
       return carSupplier.get();
    }

    private static void colliet(final Car car){
        System.out.println("Collided " + car.toString());

    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
//        //构造器引用
//        Car car = Car.create(Car::new);
//
//        //静态方法引用
//        List<Car>  cars = Arrays.asList(car);
//        cars.forEach(Car::colliet);
//
//        //特定类的任意对象的方法引用：
//        cars.forEach(Car::repair);
//        //特定对象的方法引用：它的语法是instance::method实例如下：
//        Car police = Car.create( Car::new );
//        cars.forEach(car::follow);

        System.out.println(999/1000*1000);
    }
}
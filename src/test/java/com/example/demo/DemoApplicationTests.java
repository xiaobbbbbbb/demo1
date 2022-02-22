package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
//        Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );
//
//        //复杂的语句可用{} 将语句块括起来
//        Arrays.asList( "a", "b", "d" ).forEach( e -> {
//            System.out.print( e );
//            System.out.print( e );
//        } );
//
//        //Lambda表达式可以引用类成员和局部变量（会将这些变量隐式得转换成final的），例如下列两个代码块的效果完全相同：
//        String separator = ",";
//        Arrays.asList( "a", "b", "d" ).forEach(
//                ( String e ) -> System.out.print( e + separator ) );
//
//        final String separator2 = ",";
//        Arrays.asList( "a", "b", "d" ).forEach(
//                ( String e ) -> System.out.print( e + separator2 ) );

        List<String > slist = Arrays.asList( "c", "a", "d" );
        slist.forEach(e->System.out.println(e));
        slist.sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
        slist.forEach(e->System.out.println(e));

        Function<Integer, String> sf = String::valueOf;
        String s = sf.apply(12321);
        System.out.println(s);

        //ClassName::instanceMethod  类的实例方法：把表达式的第一个参数当成instanceMethod的调用者，其他参数作为该方法的参数
        BiPredicate<String, String> sbp = String::equals;
        //等效
        BiPredicate<String, String> sbp2 = (x, y) -> x.equals(y);
        boolean test = sbp.test("a", "A");
        System.out.println(test);
    }

    public static class Car {
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }
    }


}




@DocumentA
class  A{

}

@DocumentB
class B extends A{
    public static void main(String[] s){
        Class<?> clazz = B.class;
        //根据指定注解类型获取该注解
        DocumentA documentA = clazz.getAnnotation(DocumentA.class);
        System.out.println("A:"+documentA);

        //获取该类上的所有注解包括父类的
        Annotation[] annotations =clazz.getAnnotations();
        System.out.println("annotations:"+ Arrays.toString(annotations));

        //获取该元素上的所有注解 不包括父类的
        Annotation[] annotations2 =clazz.getDeclaredAnnotations();
        System.out.println("annotations2:"+ Arrays.toString(annotations2));

        //判断注解A是否在该元素上
        boolean flag = clazz.isAnnotationPresent(DocumentA.class);
        System.out.println("flag:"+flag);
    }
}

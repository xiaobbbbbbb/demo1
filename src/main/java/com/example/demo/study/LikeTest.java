package com.example.demo.study;

/**
 * LikeTest
 *
 * @author: niko
 * @date: 2021/7/26 14:23
 */
public class LikeTest {

  //方式2 静态内部类
  static class Like2 implements ILike{

    @Override
    public void lambda() {
      System.out.println("lambda2");

    }
  }

  public static void main(String[] args) {
    ILike like = new Like1();
    like.lambda();
    like = new Like2();
    like.lambda();

    //方式3 局部内部类
    class Like3 implements ILike{

      @Override
      public void lambda() {
        System.out.println("lambda3");

      }
    }

    like = new Like3();
    like.lambda();

    //方式4 匿名内部类
    like = new ILike() {
      @Override
      public void lambda() {
        System.out.println("lambda4");

      }
    };
    like.lambda();

    //方式5 用lambda表达式简化
    like = ()->System.out.println("lambda5");
    like.lambda();
  }

}


 interface ILike{
  public void lambda();
}

//方式1 实现接口
class Like1 implements ILike {

  @Override
  public void lambda() {
    System.out.println("lambda1");
  }
}
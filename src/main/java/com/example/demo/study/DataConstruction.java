package com.example.demo.study;

/**
 * DataConstruction
 *
 * @author: niko
 * @date: 2021/8/5 15:48
 */
public class DataConstruction {

  /**
   * 数据结构 算法 复杂度
   */

  public static void main(String[] args) {

//    int a = 12;
//    int b = 12;
//     a = a ^ b;
//
//    System.out.println("a:"+a+"b:"+b);

    getX();

  }

  public int func1(int n){

    /**
     *请计算下func1计算了多少次?
     * f(n) = n^2+2*n+10   采用大O的渐进表示法  约等于 f(n) = n^2 时间复杂度为O(n^2)
     */
    int count =0 ;
    for(int i=0;i<n;++i){
       for(int j=0;j<n;++j){
          ++count;
       }
    }

    for(int k=0;k<2*n;k++){
      count++;
    }

    int m =10;
    while (m>0){
      m--;
      count++;
    }
    return count;
  }

  /**
   * 0到N的整数 缺失一个 找出那个缺失的整数
   * 要求时间复杂度为O(n)
   * 思路：用异或
   */

  public static void getX(){
      int[]  ints ={1,2,3,5,6,7,8,9,10};
      int x =0;
      for(int i=0;i<ints.length;i++){
          x ^= ints[i];
        System.out.println("第一次:"+x);

      }
      for(int i=1;i<=ints.length+1;i++){
         x ^= i;
        System.out.println("第2次:"+x);

      }
  }

}



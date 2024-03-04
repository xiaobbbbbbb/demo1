package com.example.demo.study;

/**
 * BolanExpress
 *
 * @author: niko
 * @date: 2021/8/26 17:00
 */
public class BolanExpress {



    public static void main(String[] args) {


        /**
         * 用递归演绎一个走迷宫的图
         * 思路:1.先定义一个二维数组模拟各个格子
         * 2.墙的值定义为1 ，未走的值定义为0，已走过的格子定义为2，不能走的格子定义为3
         * 3.定义走路的策略，路如果不通要回到原点，采用下、右、上、左的步骤
         */
        int[][] map = new int[8][7];

        //四面墙值赋1
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for(int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置几个卡点
        map[1][3]=1;
        map[2][3]=1;
        map[3][3]=1;
        map[3][1]=1;

        //输出地图
        for(int i=0;i<=7;i++){
            for(int j=0;j<=6;j++){
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("------解题-----");
        goNext(map,1,1);
        //输出地图
        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }

    }

    //走棋的方法 下 右 上 左
    public static boolean goNext(int[][] map,int i,int j){
        if(map[6][5]==2){//表示已走到终点
            return true;
        }else{
            if(map[i][j]==0){//还没走
                //按照策略往下走
                map[i][j]=2;
                if(goNext(map,i+1 ,j)){//下
                    return true;
                }else if(goNext(map,i,j+1)){//右
                    return true;
                }else if(goNext(map,i-1,j)){//上
                    return true;
                }else if(goNext(map,i,j-1)){//左
                    return true;
                }else {
                    //上下左右都不能走说明此路不通
                    map[i][j]=3;
                    return false;
                }
            }else{
                return false;
            }
        }

    }

    //走棋的方法 上 右 下 左
    public static boolean goNext2(int[][] map,int i,int j){
        if(map[6][5]==2){//表示已走到终点
            return true;
        }else{
            if(map[i][j]==0){//还没走
                //按照策略往下走
                map[i][j]=2;
                if(goNext2(map,i-1,j)){//上
                    return true;
                }
                else if(goNext2(map,i,j+1)) {//右
                    return true;
                }
                else if(goNext2(map,i+1 ,j)){//下
                    return true;
                }else if(goNext2(map,i,j-1)){//左
                    return true;
                }else {
                    //上下左右都不能走说明此路不通
                    map[i][j]=3;
                    return false;
                }
            }else{
                return false;
            }
        }

    }



    //打印问题
    public  void test(int n){
        if(n>2){
            test(n-1);
        }
        System.out.println("n:"+n);
    }

    //阶乘问题
    public long factorial(int n){
        if(n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }



}

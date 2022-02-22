package com.example.demo.study;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * SortTest
 * 排序算法
 * @author: niko
 * @date: 2021/9/1 13:47
 */
public class SortTest {



    /**
     *
     * 8大排序方法
     * 内部排序 1.冒泡排序
     * 外部排序
     *
     */

    //1.冒泡排序 从小到大排序 时间复杂度O(n^2)
    public static void maopao(int[] arr){
        System.out.println("冒泡排序前："+JSONUtil.toJsonStr(arr));
        boolean flag=false;
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                int temp = arr[j];
                if(arr[j]>arr[j+1]){
                    flag = true;
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    count++;
                }
            }
            if(!flag){//如果没有交换则说明顺序已经定了 后面不需要继续交换了
                break;
            }else{
                flag=false;
            }
            System.out.println("冒泡排序中："+ JSONUtil.toJsonStr(arr));
        }
        System.out.println("冒泡计算次数："+ count);
        System.out.println("冒泡排序后："+ JSONUtil.toJsonStr(arr));
    }

    /**
     * 选择排序 从数组中选择一个最小的数跟前一个数进行交换
     * @param arr
     */
    public static void choose(int[] arr){
        System.out.println("选择排序前："+JSONUtil.toJsonStr(arr));
        int count=0;
        for(int i=0;i<arr.length;i++){
//            int temp = arr[i];
//            int index = i;
            for(int j=i+1;j<arr.length;j++){
                int temp=arr[i];
                if(arr[i]>arr[j]){
                    arr[i]=arr[j];
                    arr[j] =temp;
                    temp=arr[j];
                    count++;
                }
                System.out.println("选择排序中："+JSONUtil.toJsonStr(arr));
            }

        }
        System.out.println("选择排序后："+JSONUtil.toJsonStr(arr));

    }

    /**
     * 插入排序 从小到大
     * 从一个无序数据集合中 每次取出一个元素 插入当前有序的集合中，按照一定顺序插入，新的集合初始大小为1
     */
    public static void insert(int[] arr){
        System.out.println("排序前："+JSONUtil.toJsonStr(arr));
        int num=0;
        for(int i=0;i<arr.length-1;i++){
            int temp =arr[i+1];//待插入的数据
            int index =i;

            while (index>=0&&temp<arr[index]){
                arr[index+1]=arr[index];
                index--;
                num++;
            }
            if(index+1!=(i+1)) {//如果相等 说明待插入的值就是当前位置不需要要赋值
                arr[index + 1] = temp;
            }
//            System.out.println("排序中："+JSONUtil.toJsonStr(arr));
        }
        System.out.println("排序后："+JSONUtil.toJsonStr(arr));
        System.out.println("一共运算次数："+num);

    }

    /**
     * 希尔排序 二分法-基于冒泡排序
     */
    public static void shellSort(int[] arr){
        System.out.println("排序前:"+JSONUtil.toJsonStr(arr));
        int num=0;
        for(int grap=arr.length/2;grap>0;grap=grap/2) {
            for(int i=grap;i<arr.length;i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - grap]){
                    while (j - grap >= 0 && arr[j] < arr[j - grap]) {
                        arr[j] = arr[j - grap];
                        j -= grap;
                    }
                    arr[j] = temp;
                }
            }
//            for (int i = 0; i < grap; i++) {
//                for(int j=i+grap;j<arr.length;j+=grap){
//                    int k =j-grap;
//                    while (k >= 0 && arr[k] > arr[k+grap]) {
//                        int temp = arr[k];
//                        arr[k] = arr[k+grap];
//                        arr[k + grap] = temp;
//                        k -= grap;
//                    }
//
////                    System.out.println(JSONUtil.toJsonStr(arr));
//                }
//
//            }
            System.out.println("第"+grap+"轮:"+JSONUtil.toJsonStr(arr));

        }
        System.out.println("增量缩减次数："+num);
        System.out.println("排序后:"+JSONUtil.toJsonStr(arr));

        //最后再进行插入排序
//        insert(arr);
    }

    /**
     * 快速排序
     * 两种方式 一个是填坑法 ，一个是指针交换
     * @param
     */
    public static void quickSort(int[] arr,int left ,int right){
        //递归结束的条件是left大于等于right停止
        if(left>=right){
            return;
        }
        int l=left;
        int r=right;
        int pivot=left;//基准元素
        while(l<r){
            //控制right指针比较并左移
            while(l<r&&arr[r]>arr[pivot]){
                r--;
            }
            //控制left指针比较并右移
            while(l<r&&arr[l]<=arr[pivot]){
                l++;
            }
            //交换l和r指针指向的元素
            if(l<r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }

        }
        //当指针重合的时候交换pivot
        int p = arr[l];
        arr[l]= arr[left];
        arr[left]= p;

        System.out.println("第一轮过后:"+JSONUtil.toJsonStr(arr));

        quickSort(arr,left,l-1);
        quickSort(arr,l+1,right);
    }

    /**
     * 归并排序
     * @param
     */
    public static void mergeSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        if(left<right) {
            int mid =(left + right) / 2;
            //左边归并排序 使左边有序
            System.out.println("左边left:"+left+"mid:"+mid+"right:"+right);

            mergeSort(arr,left,mid);
            //右边归并排序 使右边有序
            System.out.println("右边left:"+left+"mid:"+mid+"right:"+right);

            mergeSort(arr,mid+1,right);
            //将分治的元素合并
            merge(arr,left,mid,right);

        }

    }
    private static void merge(int[] arr,int left,int mid ,int right){

        int l = left;//左边序列的指针
        int r = mid+1;//右边序列的指针
        int t =0;//临时指针
        int[] temp = new int[right-left+1];
        while(l<=mid&&r<=right){
            if(arr[l]<=arr[r]){
                temp[t++]=arr[l++];
            }else {
                temp[t++]=arr[r++];
            }
        }
        //以下两个while 只有一个会执行
        while(l<=mid){//将左序列剩余元素填充进temp中
            temp[t++]=arr[l++];
        }
        while (r<=right){//将右序列剩余元素填充进temp中
            temp[t++]=arr[r++];
        }
        t=0;
        while (left<=right){//将temp中的元素全部拷贝到原数组中
            arr[left++] = temp[t++];
        }
        System.out.println("归并后："+JSONUtil.toJsonStr(arr));

    }

    /**
     * 算法题
     * 给出一组正整数数组，每个数组不可分割，返回最大的数的字符串形式 因为可能数字很大用字符串表示
     * [1,23,20,3,8] 返回 8323301
     */
    public static String solve(int[] nums){
        //解题思路：比较位数，首位最大的是放在前面，如果元素的位数一样的则大的在前面
        for(int i=nums.length-1;i>0;i--){
//            int temp = arr[i];
//            int index = i;
            for(int j=i-1;j>=0;j--){
                int temp=nums[i];
                if(String.valueOf(nums[i]).length()==String.valueOf(nums[j]).length()){
                    if(nums[i]>nums[j]) {
                        nums[i] = nums[j];
                        nums[j] = temp;
                        temp = nums[j];
                    }
                }else{
                    if (Integer.parseInt(String.valueOf(nums[i]).substring(0,1))>Integer.parseInt(String.valueOf(nums[j]).substring(0,1))){
                        nums[i] = nums[j];
                        nums[j] = temp;
                        temp = nums[j];

                    }else if (Integer.parseInt(String.valueOf(nums[i]).substring(0,1))==Integer.parseInt(String.valueOf(nums[j]).substring(0,1))&&nums[i]>nums[j]){
                        nums[i] = nums[j];
                        nums[j] = temp;
                        temp = nums[j];
                    }
                }
            }

        }
        StringBuffer sb =new StringBuffer();
        for(int i :nums){
            sb.append(i);
        }
        return sb.toString();
    }

    /**
     * 基数排序(桶排序)
     */
    public static void bucketSort(int[] arr){
        //找出最大的数
        int max=arr[0];
        for(int i =0 ;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //最大数的位数
        int len = (max+"").length();
        //定义10个桶 根据选定的基数存放对对应的桶内 每个桶最多存放的数据个数为arr.length 用空间换时间
        int[][] bucket = new int[10][arr.length];
        //定义一个数据来计数 记录当前的下标的桶内存放的数据个数
        int[] count =new int[10];
        for(int swap=1,n=1;swap<=len;swap++,n=n*10) {
            //第一轮 按个位数存放
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i]/n % 10;
                bucket[index][count[index]] = arr[i];
                count[index]++;
            }
            //再把桶内的数据取出来
            int idx = 0;
            for (int k = 0; k < 10; k++) {
                for (int j = 0; j < count[k]; j++) {
                    arr[idx++] = bucket[k][j];
                }
                //count 清空
                count[k]=0;
            }
            System.out.println("排序后:" + JSONUtil.toJsonStr(arr));

        }
    }

    public static void main(String[] args) {
        int[] arr ={21,30,12,324,45,3,6,7,22,45,678,22,567,234,52,56};
        int[] arr2 =new int[5000000];
        for(int i=0;i<5000000;i++){//随机生成5万个数
            arr2[i] = (int)(Math.random()*1000000);
        }
        long time1 =System.currentTimeMillis();
//        maopao(arr);
//        choose(arr);
//        insert(arr);
//        shellSort(arr);
//        quickSort(arr,0,arr.length-1);
//        mergeSort(arr,0,arr.length-1);
//        solve(arr);
        bucketSort(arr);
        System.out.println("排序耗时："+(System.currentTimeMillis()-time1)+"毫秒");
    }



}

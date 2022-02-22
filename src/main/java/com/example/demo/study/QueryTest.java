package com.example.demo.study;

/**
 * QueryTest
 * 查找算法
 * @author: niko
 * @date: 2021/9/22 15:44
 */
public class QueryTest {

    /**
     * 线性查找 遍历集合
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr ,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找法 (递归)
     * 给出的数组要是有序的数组
     * @param arr
     * @param target
     * @return
     */
    public static int midSearch(int[] arr,int target,int left,int right){
        int mid = (left+right)>>1;
        if(arr[mid]==target){
            return mid;
        }else if (arr[mid]>target&&left<mid){//向左递归
            return midSearch(arr,target,left,mid-1);
        }else if (arr[mid]<target&&right>mid){//向右递归
            return midSearch(arr,target,mid+1,right);
        }else {
            return -1;
        }
    }

    /**
     * 二分查找法 (迭代)
     * 给出的数组要是有序的数组
     * @param arr
     * @param target
     * @return
     */
    public static int midSearch2(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid = (left+right)>>1;
            if(arr[mid]==target){
                right=mid;
                return mid;
            }else if (arr[mid]>target){
                right=mid-1;
            }else if(arr[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }

    /**
     * 插值查找 中位数定义 为 mid=left+(right-left)*(val-arr[left])/(arr[right]-arr[left])
     * 对于数组分布均匀的数列用插值查找会比较快
     * @param
     */
    public static int chazhiSearch(int[] arr,int target,int left,int right){
        if(left>right||target>arr[right]||target<arr[left]){
            return -1;
        }
        int mid = left+(right-left)*(target-arr[left])/(arr[right]-arr[left]);
        System.out.println("mid:"+mid);
        if(arr[mid]==target){
            return mid;
        }else if(arr[mid]>target&&left<mid){//向左递归
            return chazhiSearch(arr,target,left,mid-1);
        }else if (arr[mid]<target&&right>mid){//向右递归
            return chazhiSearch(arr,target,mid+1,right);
        }else{
            return -1;
        }
    }

    /**
     * fibonacci 查找 mid=f(k-1)-1; f(k)=f(k-1)+f(k-2)
     * @param args
     */

    public static void main(String[] args) {
        int[] arr={3,4,7,8,9,12,45,60,78,1000};
//        int i  = midSearch(arr,3,0,arr.length-1);
//        int i  = midSearch2(arr,123);
        int i = chazhiSearch(arr,60,0,arr.length-1);
        System.out.println("找到目标："+i);
    }
}

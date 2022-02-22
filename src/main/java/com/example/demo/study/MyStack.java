package com.example.demo.study;

import java.util.ArrayList;
import java.util.List;

/**
 * MyStack
 * java 模拟栈实现 栈结构特点是fifo(先进后出)
 * @author: niko
 * @date: 2021/8/19 17:26
 */
public class MyStack<T> {

    private List<T> data;
    private int size=0;

    MyStack(){
        data =new ArrayList<>();
    }

    public void push(T t){
        data.add(t);
        System.out.println("添加元素:"+t);
        size++;
    }

    public T pop(){
        if(size<1){
            System.out.println("栈为空");
            return null;
        }
        T t = data.get(size-1);
        data.remove(size-1);
        size--;
        System.out.println("移除元素:"+t);
        return t;
    }

    //取出栈顶的元素
    public T pick(){
        if(size<1){
            System.out.println("栈为空");
            return null;
        }
        T t = data.get(size-1);
        return t;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size<=0;
    }

    //判断操作符的优先级
    public int getType(char oper){
        if(oper=='*'||oper=='/'){
            return 2;
        }else if(oper=='+'||oper=='-'){
            return 1;
        }else{
            return -1;
        }
    }

    /**
     * 判断是不是运算符
     */
    public boolean isOperate(char ch){
        return ch=='+'||ch=='-'||ch=='*'||ch=='/';
    }

    /**
     *  根据操作符做计算
     * @return
     */
    public int calc(int num1,int num2,int oper){
        int res=0;
        switch (oper) {
            case '+':
                res = num1 + num2;break;
            case '-':res =num2-num1;break;
            case '*':res=num1*num2;break;
            case '/':res=num2/num1;break;
            default:break;
        }
        return res;
    }

    public static void main(String[] args) {
        String expr="3+6*7-6";
        MyStack<Integer> dataStack =new MyStack<>();
        MyStack<Character> optStack =new MyStack<>();

        int index=0;
        int num1=0;
        int num2=0;
        int res=0;
        int opt=0;
        char ch;
        //利用栈做计算器
        //遍历表达式
        while(true){
            //依次扫描每个字符
            ch = expr.substring(index,index+1).charAt(0);
            //判断字符是不是一个操作符
            if(optStack.isOperate(ch)){//如果是
                if(!optStack.isEmpty()){//如果栈不为空
                    //栈顶符号的优先级
                    char top = optStack.pick();
                    int topType = optStack.getType(top);
                    //当前的优先级
                    int chType = optStack.getType(ch);
                    //如果当前的符号比栈里的符号优先级高 则入栈，否则就取出数据栈的数据进行计算
                    if(chType>topType){
                        optStack.push(ch);
                    }else{//取出数据栈中的数据做运算
                        num1=dataStack.pop();
                        num2=dataStack.pop();
                        opt=optStack.pop();
                        res = dataStack.calc(num1,num2,opt);
                        //计算完之后将数据和符号入栈
                        dataStack.push(res);
                        optStack.push(ch);
                    }
                }else{//为空则符号直接入栈
                    optStack.push(ch);
                }
            }else {
                dataStack.push(ch-48);
            }
            index++;
            if(index>=expr.length()){
                break;
            }
        }
        //添加完毕之后再顺序的取出栈中的数据进行计算
        while(true){
            if(optStack.isEmpty()){
                break;
            }
            num1=dataStack.pop();
            num2=dataStack.pop();
            opt=optStack.pop();
            res = dataStack.calc(num1,num2,opt);
            //计算完之后将数据和符号入栈
            dataStack.push(res);
        }
        System.out.println("计算的结果为:"+dataStack.pop());
    }
}

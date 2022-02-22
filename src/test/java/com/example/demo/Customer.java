package com.example.demo;

/**
 * Customer
 *
 * @author: niko
 * @date: 2021/4/30 11:25
 */
public class Customer {
  private int id=100 ;
  private String name;
  private Account account;

  {
    name="匿名客户";
  }
  public Customer(){
    account=new Account();
  }

}

class Account{
  private Double money;
}
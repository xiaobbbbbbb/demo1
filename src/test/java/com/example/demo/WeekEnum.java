package com.example.demo;

import io.swagger.models.auth.In;

/**
 * WeekEnum
 *
 * @author: niko
 * @date: 2021/6/4 15:52
 */
public enum WeekEnum {
  MONDAY("xxx",1);


  private String name ;
  private int value;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  WeekEnum(String name, int value) {
    this.name=name;
    this.value=value;
  }
}

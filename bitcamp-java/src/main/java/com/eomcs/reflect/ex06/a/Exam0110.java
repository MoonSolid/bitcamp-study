package com.eomcs.reflect.ex06.a;

import java.lang.reflect.Proxy;

public class Exam0110 {
  public static void main(String[] args) throws Exception {

    MyInterface obj = (MyInterface) Proxy.newProxyInstance(//
        Exam0110.class.getClassLoader(), new Class[] {MyInterface.class},
        new MyInvocationHnadler());

    obj.m1();
  }
}

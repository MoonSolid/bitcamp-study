package com.eomcs.basic.ex05;

//# 비트 연산자 & 를 이용하여 % 연산 구현
//
public class Exam0352 {
  public static void main(String[] args) {

    System.out.println(57 % 2 == 0 ? "짝수" : "홀수");
    System.out.println((57 & 0x1) == 0 ? "짝수" : "홀수");


  }
}
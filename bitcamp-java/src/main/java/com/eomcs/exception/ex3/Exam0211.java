// 예외 던지기 - 예외 상황을 호출자에게 알려주기
package com.eomcs.exception.ex3;

public class Exam0211 {


  static void m1() throws Error {
    throw new Error(); // OK!
  }

  // 여러 개의 오류
  static void m2() {
    throw new Error(); // OK!
  }



  public static void main(String[] args) {}

}

// Wrapper 클래스 - auto-boxing/auto-unboxing 
package com.eomcs.corelib.ex01;

public class Exam0221 {
  public static void main(String[] args) {

    // 자바는 primitive date type 값을  Wrapper 클래스의 인스턴스에 바로 할당할 수 있다.
    Integer obj = 100;
    //obj는 레퍼런스인데 어떻게 가능한가?
    // => 내부적으로 Integer.valueOf(i1)으로 바뀐다.
    // => 즉 int 값이 obj3에 저장되는 것이 아니라,
    // 내부적으로 Integer 객체가 생성되어 그 주소가 저장된다.
    // =>이렇게 int 값을 자동으로 Integer 객체로 만드는 것을 
    // "오토박싱(auto-boxing)"이라 한다.
    
   


  }
}







package com.eomcs.basic.ex07.test;

public class Test01 {
  public static void main(String[] args) {

    // 입력 값 : X, 리턴 값: X
    m1();


    // 입력 값 : O, 리턴 값: X
    m2("홍길동");


    // 입력 값 : x, 리턴 값: o


    // 입력 값: o, 리턴 값: o
    String s2 = m3("홍길동");  //아규먼트
    System.out.println(s2);
  

  String s;              //데이터타입 지정
  s = m3();              //문자열을 리턴받음
  System.out.println(s);




  static void m1() {
    System.out.println("Hello!");
  }



  static void m2(String name) {   //파라미터
    // 함수 안에 선언된 변수를 "로컬(local) 변수"라 부른다.
    // 로컬 변수 중에서 함수(메서드)를 호출될 때 입력 넘어 온 값을 
    // 받는 변수를 "파라미터(parameter)"라 부른다.
    // 함수를 호출할 때 넘겨주는 값을 "아규먼트(argument)"라 부른다.
    // 
    System.out.println("Hello, " + name);
  }
  



  static String m3() {              //void의 위치는 리턴하는 데이터타입을 적어준다
    String message = "Hello!";
    return message;
  }

  static String m4(String name) {
    String message = name + "님 안녕하세요!";
    return message;
    }


}





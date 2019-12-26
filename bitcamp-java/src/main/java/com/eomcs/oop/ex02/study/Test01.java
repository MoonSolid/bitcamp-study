package com.eomcs.oop.ex02.study;

public class Test01 {
  public static void main(String[] args) {

    Score s = new Score();

    s.name = "홍길동";
    s.kor = 100;
    s.eng = 90;
    s.math = 80;
    
    s.calculate();  //calculate는 데이터를 다루는 기능을 가진 메서드이기 때문에 연산자 , operate 라고도 부른다. 
    
    System.out.println(s.sum);
    System.out.println(s.aver);
    
  }
}

   
   

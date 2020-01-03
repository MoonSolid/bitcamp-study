package com.eomcs.oop.ex06.c;

public class D2 extends D {
    @Override
    void m() {
        System.out.println("D2의 m()");
    }
    
    void test() {
      //this 레퍼런스로 메서드를 호출하면
      // ==> 현재 클래스부터 메서드를 찾아 수퍼 클래스로 올라간다
        this.m();
        
        // 만약 오버라이딩 하기 전에 메서드를 호출하고 싶다면?
        super.m();
    }
}







//static nested class
package com.eomcs.oop.ex11.a;

public class Exam0111 {
  //스태틱 멤버
  static int sValue;
  static void sm() {}
  //인스턴스 멤버
  int iValue;
  void im() {}


  //static nested class 는 스태틱 멤버이다.
  // 따라서 같은 static 멤버만 사용할 수 있다.
  static class A {
    void m1() {
      sValue = 100;  //ok
      //iValue = 100;  //컴파일 오류

      sm(); //ok
      //im(); // 컴파일 오류
    }
  }

  static void m1() {
   //static nested class는 스태틱 멤버이기 때문에
   //다른 스태틱 멤버가 사용할 수 이다.
    A obj;
    obj = new A(); //ok
   
  }

   void m2() {
    //인스턴스 멤버는 스태틱 멤버를 사용할 수 있기 떄문에
    //당연히 static nested class를 사용할 수 있다.
     A obj;
     obj = new A();
  }
  
  public void setValue(int value) {
  }

}

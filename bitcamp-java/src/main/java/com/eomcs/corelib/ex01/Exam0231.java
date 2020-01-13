// Wrapper 클래스 - wrapper 객체의 값 비교 
package com.eomcs.corelib.ex01;

public class Exam0231 {
  public static void main(String[] args) {
    Integer obj1 = 100; // constant pool에 생성
    Integer obj2 = 100; // constant pool에 생성된 기존 주소 리턴
    System.out.println(obj1 == obj2);
    // auto-boxing 이나 valueOf()로 생성한 wrapper 객체는
    // constants pool에 오직 한 개만 생성되기 떄문에
    // 값을 비교할 때 그냥 == 연산자를 사용하여 인스턴스 주소로 비교해도 된다.

    //그러나 다음과 같이 new연산자로 만든 wrapper 객체는
    //값이 같더라도 인스턴스가 따로 생성되기 때문에,
    Integer obj3 = new Integer(100); // Heap에 인스턴스 생성 
    Integer obj4 = new Integer(100); // Heap에 인스턴스 생성 

    //다음과 같이 ==연산자를 사용하여 비교하면 안된다.

    System.out.println(obj3 == obj4);
    
    // String클래스의 경우처럼
    // Integer 클래스가 오버라이딩한 equals()를 호출해야 한다.
    System.out.println(obj3.equals(obj4));


  }
}







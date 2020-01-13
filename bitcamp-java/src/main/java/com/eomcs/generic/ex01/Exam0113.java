// 제네릭(Generic) - 사용 후: 다형적 변수의 한계 극복
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam0113 {

  //Box 클래스에서 다룰 객체의 타입을 파라미터로 받는다.
  
  static class Box<T> {
    
    //T는 Box 클래스가 다루는 객체의 타입을 가리킨다.
    //그래서 T 변수를 "타입 파라미터"라고 부른다.
    //타입 파라미터도 변수이기 때문에 이름을 다음과 같이 지어도 된다.
    // dataType, obj, element 등 
    // 그러나 보통 코드를 간략하하기위해 한 개의 알파벳으로 표현한다.
    // 자바에서 제안하는 변수 이름은 다음과 가다. 
    //  T - type 
    //  E - element
    //  K - key
    //  V - value
    //  N - number
    // 여러 개의 타입 파라미터를 선언해야 할 경우 보통 두 번째  파라미터부터 다음 알파벳을 사용한다.
    //  S , U , V 등- 두 번째 파라미터 이름
    //  예) class Box<T,S,U,V> {...}
    T value;

    public void Set(T value) {
      this.value = value;
    }

    public T get() {
      return value;
    }
  }


  public static void main(String[] args) {

    //제네릭을 사용하여 정의된 클래스를 사용할 경우에는
    //클래스의 레퍼런스를 정의할 때 어떤 타입의 값을 다룰 것인지 제한을 걸어야 한다.
    //즉 지정해야 한다.
    Box<Member> box1;
    
    //인스턴스를 생성할 때도 어떤 타입의 값을 다룰 인스턴스인지 지정해야 한다.
    box1 = new Box<Member>();
    
    //객체를 생성할 때 타입 지정을 생략할 수 있다.
    box1 = new Box<>();
    
    // <>를 빼면 경고가 뜨며, 내부적으로는 Object를 타입으로 지정한 것으로 다룬다.
    // 즉 다음 코드는 box1 = new Box<Object>() 와 같다.
    // 
    //box1 = new Box(); // 경고!
    
    
    //메서드를 사용할 때 그 타입의 전용 클래스인 것처럼 쓰면 된다.
    box1.Set(new Member("홍길동",20));
    
    //따라서 다음과 같이 값을 꺼낼 때도 따로 형변환 할 필요가 없다.
    
    Member m = box1.get();
    System.out.println(m);

    //



  }
}









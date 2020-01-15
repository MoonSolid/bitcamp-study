package com.eomcs.oop.ex03.test;

public class Car {      //Car클래스에 속한 메서드의  this는 Car클래스의 데이터를 다룬다
  
  boolean on;
  int speed = 100;
  String name;
  String maker;
  Engine engine;
  int distance;
  
  
  Car() {
    this.engine = new Engine(4, 16, 1980); //해당 객체가 제대로 쓰일수 있도록 각각의 변수를 유효한 값으로 설정
  }
  
  void start() {
    this.on = true;
  }
    
  void stop() {
    this.on = false;
  }
  
  void check() {
    if (this.engine.oilState == 0) {      
      this.engine.cleanOil();
      System.out.println("자동차의 엔진 오일을 교환했습니다");
    }
    System.out.println("자동차를 정비했습니다");
  }
  
}











    

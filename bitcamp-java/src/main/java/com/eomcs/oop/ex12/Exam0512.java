// 메서드 레퍼런스(method reference) - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;

public class Exam0512 {

  static class MyCalculator {

    public static int plus(int a, int b) {
      return a + b;
    }

    public static int minus(int a, int b) {
      return a - b;
    }

    public static int multiple(int a, int b) {
      return a * b;
    }

    public static int divide(int a, int b) {
      return a / b;
    }

  }

  static interface Calculator1 {
    int compute(byte a, byte b);
  }

  static interface Calculator2 {
    int compute(short a, short b);
  }

  static interface Calculator3 {
    int compute(int a, int b);
  }

  static interface Calculator4 {
    int compute(float a, float b);
  }

  static interface Calculator5 {
    int compute(Object a, Object b);
  }

  static interface Calculator6 {
    int compute(String a, String b);
  }

  static interface Calculator7 {
    int compute(Integer a, Integer b);
  }



  public static void main(String[] args) {

    Calculator1 c1 = MyCalculator::plus;
    Calculator2 c2 = MyCalculator::plus;
    Calculator3 c3 = MyCalculator::plus;
    // Calculator4 c4 = MyCalculator::plus;
    // Calculator5 c5 = MyCalculator::plus;
    // Calculator6 c6 = MyCalculator::plus;
    Calculator7 c7 = MyCalculator::plus;


  }
}



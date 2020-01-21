// 메서드 레퍼런스(method reference) - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;


public class Exam0511 {

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
    double compute(int a, int b);
  }

  static interface Calculator2 {
    float compute(int a, int b);
  }

  static interface Calculator3 {
    short compute(int a, int b);
  }

  static interface Calculator4 {
    void compute(int a);
  }

  static interface Calculator5 {
    Object compute(int a, int b);
  }

  static interface Calculator6 {
    String compute(int a, int b);
  }



  public static void main(String[] args) {

    Calculator1 c1 = MyCalculator::plus;
    System.out.println(c1.compute(100, 200));

    Calculator2 c2 = MyCalculator::plus;
    System.out.println(c2.compute(100, 200));

    // Calculator3 c3 = MyCalculator::plus;

    // Calculator4 c4 = MyCalculator::plus;

    Calculator5 c5 = MyCalculator::plus;
    System.out.println(c5.compute(100, 200));

    // Calculator6 c6 = MyCalculator::plus;

  }

}



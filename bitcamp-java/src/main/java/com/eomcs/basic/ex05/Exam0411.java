package com.eomcs.basic.ex05;

//# 비트 이동 연산자 : >>, >>>, <<
//
public class Exam0411 {
  public static void main(String[] args) {

    System.out.println(3 << 1);
    //     000000000 00000000 00000000 0000011
    //  00|00000000 00000000 00000000 000001xx 
    //     00000000 00000000 00000000 00000100 = 4

    System.out.println(3 << 33);
    System.out.println(3 << 65);
    System.out.println(3 << 97);

    // int 값에 대한  비트 이동은 할 때 0 ~ 31 값만 유효하다.
    // long 값에 대한 비트 이동을 할 때 0 ~ 63 값만 유효하다.
    
    

  }
}






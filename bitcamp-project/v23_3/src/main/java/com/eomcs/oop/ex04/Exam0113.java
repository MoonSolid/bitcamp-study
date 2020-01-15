// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!
package com.eomcs.oop.ex04;

public class Exam0113 {

  public static void main(String[] args) throws Exception {

    //UTF-8 문자 코드의 바이트 배열을 사용하여 String 인스턴스 초기화시키기.
    
        byte[] bytes = {
        (byte)0x41, //A
        (byte)0x42, //B
        (byte)0x43, //C
        (byte)0x61, //a
        (byte)0x62, //b
        (byte)0x63, //c
        (byte)0x30, //0
        (byte)0x31, //1
        (byte)0x32, //2
        (byte)0x20, //space
        (byte)0x21, //!
        (byte)0x23, //#
        (byte)0x25, //%
        (byte)0x2b, //+
        (byte)0xea,(byte)0xb0, (byte)0x80, //가
        (byte)0xea,(byte)0xb0, (byte)0x81, //각
        (byte)0xb6,(byte)0xca,  //똘
        (byte)0xb6, (byte)0xcb//똠
  };
  String s1 = new String(bytes);
  System.out.println(s1);
  }
}















// 익명 클래스로 파일 필터 만들기
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0650 {


  public static void main(String[] args) throws Exception {
    File dir = new File(".");

    // 필터 객체를 한 개 만 만들 것이라면
    // 익명 클래스로 정의하는 것이 낫다.
    //

    // 익명 클래스를 정의할 때
    // 객체를 사용할 위치에 정의하는 것이 코드를 읽기 쉽게 한다.
    File[] files =
        dir.listFiles(file -> (file.isFile() && file.getName().endsWith(".java")) ? true : false);


    for (File file : files) {
      System.out.printf("%s %12d %s\n", file.isDirectory() ? "d" : "-", file.length(),
          file.getName());
    }

  }

}



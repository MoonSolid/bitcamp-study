// 던지는 예외 받기 - 다형적 변수의 특징을 이용하여 여러 예외를 한 catch에서 받을 수 있다.
package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0471 {

  static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
    if (i == 0)
      throw new Exception();
    else if (i == 1)
      throw new RuntimeException();
    else if (i == 2)
      throw new SQLException();
    else if (i == 3)
      throw new IOException();
    else if (i < 0)
      throw new Error();
  }

  public static void main(String[] args) {
    try {
      // try 블록에서 예외가 발생할 수 있는 메서드를 호출한다.
      m(-1);

    } catch (Throwable e) {
      System.out.println("애플리케이션 예외 발생");

    }
  }

}

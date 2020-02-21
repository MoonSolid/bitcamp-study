// 게시판 관리 - 등록
package com.eomcs.jdbc.ex2.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

// 다음과 같이 게시물을 등록하는 프로그램을 작성하라!
// ----------------------------
// 제목? aaa
// 내용? bbb
// 등록하시겠습니까?(Y/n) y
// 등록하였습니다.
// 등록하시겠습니까?(Y/n) n
// 등록을 취소 하였습니다.
// ----------------------------
public class Exam0110 {

  public static void main(String[] args) throws Exception {
    String title = null;
    String contents = null;

    try (Scanner scan = new Scanner(System.in)) {

      System.out.println("제목? ");
      title = scan.nextLine();

      System.out.println("내용? ");
      contents = scan.nextLine();

      System.out.println("등록하시겠습니까?(Y/n) ");
      String input = scan.nextLine();

      if (!input.equalsIgnoreCase("y") & input.length() != 0) {
        System.out.println("등록을 취소하였습니다");
        return;
      } else {
        System.out.println("등록하였습니다.");
      }

    }

    try (Connection con = DriverManager.getConnection(//
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement();) {

      String sql =
          String.format("insert into x_board(title,contents) values('%s','%s')", title, contents);

      int count = stmt.executeUpdate(sql);
      System.out.printf("게시글을 %d개 등록하였습니다", count);
    }
  }
}



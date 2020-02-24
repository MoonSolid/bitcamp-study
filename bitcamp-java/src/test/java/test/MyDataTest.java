package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class MyDataTest {
  public static void main(String[] args) throws Exception {
    String title = null;
    String contents = null;

    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("제목? ");
      title = scan.nextLine();

      System.out.println("내용? ");
      contents = scan.nextLine();

      System.out.println("등록하시겠습니까? (Y/n) ");
      String input = scan.nextLine();

      if (!input.equalsIgnoreCase("Y") && input.length() != 0) {
        System.out.println("등록되지 않았습니다.");
        return;
      } else {
        System.out.println("등록되었습니다.");
      }

      try (Connection con = DriverManager.getConnection( //
          "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
          Statement stmt = con.createStatement();) {


        String sql =
            String.format("insert into x_board(title,contents) values('%s','%s')", title, contents);

        int count = stmt.executeUpdate(sql);

        System.out.printf("게시글이 %d개 등록되었습니다", count);

      }



    }
  }
}



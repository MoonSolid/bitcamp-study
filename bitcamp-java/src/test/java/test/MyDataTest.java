package test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class MyDataTest {
  public static void main(String[] args) {



    try (Scanner scan = new Scanner(System.in);
        OutputStream out = new FileOutputStream("/vote.txt");) {
      System.out.println("투표할 인원을 입력하세요");
      String str = scan.nextLine();
      byte[] by = str.getBytes();
      out.write(by);

    } catch (Exception e) {

    }



  }
}



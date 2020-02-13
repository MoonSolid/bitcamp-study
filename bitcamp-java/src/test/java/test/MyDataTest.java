package test;

import java.util.Scanner;

public class MyDataTest {

  static class MyThread extends Thread {
    @Override
    public void run() {
      Scanner scan = new Scanner(System.in);
      System.out.print("입력하시오> ");
      String input = scan.nextLine();
      System.out.println("입력값 : " + input);
      scan.close();
    }
  }


  public static void main(final String[] args) {

    MyThread t = new MyThread();

    t.start();
    System.out.println("메인문 끝");


  }
}



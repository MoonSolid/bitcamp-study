package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;


public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);


    // 게시글 데이터를 저장할 메모리를 설계한다.
    class Board {
      int no;
      String title;
      Date date;
      int viewCount;
    }

    final int SIZE = 100;
    
    //board 인스턴스의 주소를 담을 레퍼런스 배열을 준비한다.
    Member[] boards = new Board[SIZE];
    
    //Board 인스턴스를 생성하여 레퍼런스 배열에 저장한다.(SIZE만큼)
    for (int i = 0; i < SIZE; i++) {
      boards[i] = new Board();
    }
    
    




    String response;

    int count = 0;
    for (int i = 0; i < 100; i++) {
      
      Board board = boards[i];
      
      System.out.print("번호? ");
      boards[i].no = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈 기호 제거용

      System.out.print("내용? ");
      boards[i].title = keyboard.nextLine();

      boards[i].date = new Date(System.currentTimeMillis());
      boards[i].viewCount = 0;
      
      count++;
      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      response = keyboard.nextLine();

      if (!response.equalsIgnoreCase("y")) {
        break; //반복문을 멈춰라
      }
    }

    keyboard.close();

    System.out.println();

    for (int i = 0; i < count; i++) {
      Board board = boards[i];
      
      System.out.printf("%d, %s, %s, %d\n",
          board.no[i], board.title[i], board.date[i], board.viewCount[i]);
    }
  }
}

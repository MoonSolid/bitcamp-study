package handler;

import java.sql.Date;
import java.util.Scanner;
import domain.Board;

public class BoardHandler {  //클래스 괄호 안을 클래스 필드라고함


  //인스턴스 필드
  // -> new 명령을 실행해야만 생성되는 변수
  // -> 개별적으로 관리되어야 하는  값일 경우 인스턴스 필드로 선언한다.
  //
  Board[] boards = new Board[BOARD_SIZE];  //개별관리시 static 을 사용하지않음
  int boardCount = 0;

  //클래스 필드 , 스태틱 필드 
  // -> method area에 클래스 코드가 로딩될 때 자동 생성된다.
  // -> 공통으로 사용할 값일 경우 클래스 필드로 선언한다.
  // -> 
  static final int BOARD_SIZE = 100;   //상수는 변하지않으므로 개별관리할 필요가 없다
  public static Scanner keyboard;

  //클래스 메서드 
  // -> 인스턴스 없이 호출하는 메서드이다.
  // -> 인스턴스를 사용하려면 파라미터를 통해 호출할 때 외부에서 받아야 한다.

  public static void addBoard (BoardHandler boardHandler) {          //공유할 메서드 

    Board board = new Board();

    System.out.print("번호? ");
    board.no = keyboard.nextInt();
    keyboard.nextLine(); // 줄바꿈 기호 제거용

    System.out.print("내용? ");
    board.title = keyboard.nextLine();

    board.date = new Date(System.currentTimeMillis());
    board.viewCount = 0;

    boardHandler.boards[boardHandler.boardCount++] = board;
    System.out.println("저장하였습니다.");

  }

  public static void detailBoard(BoardHandler boardHandler) {
    System.out.print("게시물 번호? ");
    int no = keyboard.nextInt();
    keyboard.nextLine();  

    Board board = null;
    for (int i = 0; i < boardHandler.boardCount; i++) {
      if (boardHandler.boards[i].no == no) {
        board = boardHandler.boards[i];                     //게시글 번호를  배열의 번호가 아닌 게시글 고유번호로 지정
        break;
      }
    }

    if (board == null) {
      System.out.println("게시물 번호가 유효하지 않습니다. ");
      return;
    }

    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("등록일: %s\n", board.date);
    System.out.printf("조회수: %d\n", board.viewCount);


  }

  public static void listBoard (BoardHandler boardHandler) {  //보드핸들러의 인스턴스 주소를받음

    for (int i = 0; i < boardHandler.boardCount; i++) {
      Board m = boardHandler.boards[i];
      System.out.printf("%d, %s          , %s, %d\n", 
          m.no, m.title       , m.date, m.viewCount);
    }

  }


}

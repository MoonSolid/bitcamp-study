package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList;

public class BoardHandler {

  ArrayList<Board> boardList;

  Scanner input;


  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new ArrayList<>();
  }

  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    this.boardList = new ArrayList<>(capacity);
  }

  public void listBoard() {
    // BoardList의 보관된 값을 받을 배열을 준비한다.
    Board[] arr = new Board[this.boardList.size()];

    // toArray()에게 빈 배열을 넘겨서 복사 받는다.
    this.boardList.toArray(arr);


    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(input.nextInt());
    input.nextLine(); // 줄바꿈 기호 제거용

    System.out.print("내용? ");
    board.setTitle(input.nextLine());

    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    this.boardList.add(board);

    System.out.println("저장하였습니다.");
  }

  public void detailBoard() {
    System.out.print("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Board board = this.boardList.get(index);

    if (board == null) {
      System.out.println("게시물 인덱스가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
  }


  public void updateBoard() {
    System.out.print("게시글 인덱스?");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Board oldBoard = this.boardList.get(index);

    if (oldBoard == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }


    System.out.printf("내용(%s)? ",oldBoard.getTitle());  //기존의 내용을 보여줌
    String title = input.nextLine();            //새로운 내용 입력
    
    if (title.length() == 0) {   //게시글 변경값이 없을경우 
      System.out.println("게시글 변경을 취소했습니다.");
      return;
    }
    
      //기존값을 적용
    Board newBoard = new Board();  //새로운게시글저장할 보드 객체 만들고 
    newBoard.setNo(oldBoard.getNo());  //기존의 게시글을 저장
    newBoard.setViewCount(oldBoard.getViewCount()); //기존의 조회수 저장
    newBoard.setTitle(title); //기존의 title 저장
    newBoard.setDate(new Date(System.currentTimeMillis())); // 현재 시간 저장


    this.boardList.set(index, newBoard); //보드리스트의 set을 호출해서 인덱스에 새로운 게시글을 저장
    System.out.println("게시글을 변경했습니다.");
  }
  
  public void deleteBoard() {
    System.out.print("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Board board = this.boardList.get(index);

    if (board == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    this.boardList.remove(index);
    
    System.out.println("게시글을 삭제했습니다.");
  }
}










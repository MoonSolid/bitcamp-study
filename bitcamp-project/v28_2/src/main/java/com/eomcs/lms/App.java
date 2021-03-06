package com.eomcs.lms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.ComputePlusCommand;
import com.eomcs.lms.handler.HelloCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;
import com.eomcs.util.Prompt;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  static ArrayList<Lesson> lessonList = new ArrayList<>();
  static LinkedList<Member> memberList = new LinkedList<>();
  static LinkedList<Board> boardList = new LinkedList<>();

  public static void main(String[] args) {

    // 파일에서 데이터 로딩
    loadLessonData();
    loadMemberData();
    loadBoardData();

    // 사용자로부터 입력을 받을 도구를 준비
    Prompt prompt = new Prompt(keyboard);
    // 사용자 명령어를 저장할 저장소 준비
    HashMap<String, Command> commandMap = new HashMap<>();

    // 사용자 명령을 저장소에 저장
    commandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
    commandMap.put("/board/list", new BoardListCommand(boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(prompt, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(prompt, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(prompt, boardList));

    commandMap.put("/lesson/add", new LessonAddCommand(prompt, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(prompt, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(prompt, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(prompt, lessonList));

    commandMap.put("/member/add", new MemberAddCommand(prompt, memberList));
    commandMap.put("/member/list", new MemberListCommand(memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(prompt, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(prompt, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(prompt, memberList));

    commandMap.put("/hello", new HelloCommand(prompt));
    commandMap.put("/compute/plus", new ComputePlusCommand(prompt));

    // 사용자로부터 입력받음
    String command;


    // 사용자로부터 명령을 받고
    while (true) {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      if (command.length() == 0)
        continue;
      // quit이라면 안녕을 출력하고 프로그램을 끝낸다
      if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      }
      // 사용자명령을 stack에 보관
      commandStack.push(command);

      commandQueue.offer(command);

      // 사용자입력을 찾는다
      Command commandHandler = commandMap.get(command);

      // 명령을 찾았다면 명령을 수행하고
      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          // 오류가 발생하면 오류를 출력
          System.out.printf("명령어 실행 중 오류 발생: %s\n", e.getMessage());
        }
        // 못찾았다면 출력
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }


    // 입력이 끝나고 자원을 해제한다
    keyboard.close();

    // 데이터를 파일에 저장
    saveLessonData();
    saveMemberData();
    saveBoardData();
  } // main()

  // 이전에는 Stack에서 값을 꺼내는 방법과 Queue에서 값을 꺼내는 방법이 다르기 때문에
  // printCommandHistory()와 printCommandHistory2() 메서드를 따로 정의했다.
  // 이제 Stack과 Queue는 일관된 방식으로 값을 꺼내주는 Iterator가 있기 때문에
  // 두 메서드를 하나로 합칠 수 있다.
  // 파라미터로 Iterator를 받아서 처리하기만 하면 된다.

  // 파라미터에서 명령어를 꺼내주는 객체를
  private static void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    // 값을 하나식 찾아서
    while (iterator.hasNext()) {

      // 출력하고
      System.out.println(iterator.next());
      count++;
      // 5칸을 출력하고 계속출력할지 입력받는다
      if ((count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

  private static void loadLessonData() {
    // 데이터가 보관된 파일을 정보를 준비한다.
    File file = new File("./lesson.csv");

    FileReader in = null;
    Scanner dataScan = null;

    try {
      // 파일을 읽을 때 사용할 도구를 준비한다.
      in = new FileReader(file);

      // .csv 파일에서 한 줄 단위로 문자열을 읽는 기능이 필요한데,
      // FileReader에는 그런 기능이 없다.
      // 그래서 FileReader를 그대로 사용할 수 없고,
      // 이 객체에 다른 도구를 연결하여 사용할 것이다.
      //

      // 한줄 단위로 잘라주는 스캐너를 FileReader에 덧붙인다
      dataScan = new Scanner(in); // FileReader인 in 을 Scanner에 넣어줌
      int count = 0;

      while (true) {
        try {
          // 파일에서 한 줄을 읽는다.

          // 한 줄을 콤마(,)로 나눈다.

          // 한 줄에 들어 있던 데이터를 추출하여 Lesson 객체에 담는다.
          // => 데이터 순서는 다음과 같다.
          // 번호,강의명,설명,시작일,종료일,총강의시간,일강의시간

          // Lesson 객체를 Command가 사용하는 목록에 저장한다.
          lessonList.add(Lesson.valueOf(dataScan.nextLine()));
          count++;

        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d 개의 수업 데이터를 로딩했습니다.\n", count);

    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
      // 파일에서 데이터를 읽다가 오류가 발생하더라도
      // 시스템을 멈추지 않고 계속 실행하게 한다.
      // 이것이 예외처리를 하는 이유이다!!!
    } finally {
      // 자원이 서로 연결된 경우에는 다른 자원을 이용하는 객체부터 닫는다.
      try {
        dataScan.close();
      } catch (Exception e) {
        // Scanner 객체 닫다가 오류가 발생하더라도 무시한다.
      }
      try {
        in.close();
      } catch (Exception e) {
        // close() 실행하다가 오류가 발생한 경우 무시한다.
        // 왜? 닫다가 발생한 오류는 특별히 처리할 게 없다.
      }
    }
  }



  private static void saveLessonData() {
    // 데이터가 보관된 파일을 정보를 준비한다.
    File file = new File("./lesson.csv");

    FileWriter out = null;

    try {
      // 파일에 데이터를 저장할 때 사용할 도구를 준비한다.
      out = new FileWriter(file);
      int count = 0;

      for (Lesson lesson : lessonList) {
        // 수업 목록에서 수업 데이터를 꺼내 CSV 형식의 문자열로 만든다.

        out.write(lesson.toCsvString() + "\n");
        count++;
      }
      System.out.printf("총 %d 개의 수업 데이터를 저장했습니다.\n", count);

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
        // FileWriter를 닫을 때 발생하는 예외는 무시한다.
      }
    }
  }

  private static void loadMemberData() {
    // 데이터가 보관된 파일을 정보를 준비한다.
    File file = new File("./member.csv");

    FileReader in = null;
    Scanner dataScan = null;

    try {
      // 파일을 읽을 때 사용할 도구를 준비한다.
      in = new FileReader(file);

      // .csv 파일에서 한 줄 단위로 문자열을 읽는 기능이 필요한데,
      // FileReader에는 그런 기능이 없다.
      // 그래서 FileReader를 그대로 사용할 수 없고,
      // 이 객체에 다른 도구를 연결하여 사용할 것이다.
      //
      dataScan = new Scanner(in);
      int count = 0;

      while (true) {
        try {
          // 파일에서 한 줄을 읽는다.

          // 한 줄을 콤마(,)로 나눈다.

          // 한 줄에 들어 있던 데이터를 추출하여 Lesson 객체에 담는다.
          // => 데이터 순서는 다음과 같다.
          // 번호,강의명,설명,시작일,종료일,총강의시간,일강의시간


          // Member 객체를 Command가 사용하는 목록에 저장한다.
          memberList.add(Member.valueOf(dataScan.nextLine()));
          count++;

        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d 개의 회원 데이터를 로딩했습니다.\n", count);

    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
      // 파일에서 데이터를 읽다가 오류가 발생하더라도
      // 시스템을 멈추지 않고 계속 실행하게 한다.
      // 이것이 예외처리를 하는 이유이다!!!
    } finally {
      // 자원이 서로 연결된 경우에는 다른 자원을 이용하는 객체부터 닫는다.
      try {
        dataScan.close();
      } catch (Exception e) {
        // Scanner 객체 닫다가 오류가 발생하더라도 무시한다.
      }
      try {
        in.close();
      } catch (Exception e) {
        // close() 실행하다가 오류가 발생한 경우 무시한다.
        // 왜? 닫다가 발생한 오류는 특별히 처리할 게 없다.
      }
    }
  }



  private static void saveMemberData() {
    // 데이터가 보관된 파일을 정보를 준비한다.
    File file = new File("./member.csv");

    FileWriter out = null;

    try {
      // 파일에 데이터를 저장할 때 사용할 도구를 준비한다.
      out = new FileWriter(file);
      int count = 0;

      for (Member member : memberList) {
        // 회원 목록에서 회원 데이터를 꺼내 CSV 형식의 문자열로 만든다.

        out.write(member.toCsvString() + "\n");
        count++;
      }
      System.out.printf("총 %d 개의 회원 데이터를 저장했습니다.\n", count);

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
        // FileWriter를 닫을 때 발생하는 예외는 무시한다.
      }
    }
  }

  private static void loadBoardData() {
    // 데이터가 보관된 파일을 정보를 준비한다.
    File file = new File("./board.csv");

    FileReader in = null;
    Scanner dataScan = null;

    try {
      // 파일을 읽을 때 사용할 도구를 준비한다.
      in = new FileReader(file);

      // .csv 파일에서 한 줄 단위로 문자열을 읽는 기능이 필요한데,
      // FileReader에는 그런 기능이 없다.
      // 그래서 FileReader를 그대로 사용할 수 없고,
      // 이 객체에 다른 도구를 연결하여 사용할 것이다.
      //
      dataScan = new Scanner(in);
      int count = 0;

      while (true) {
        try {
          // 파일에서 한 줄을 읽는다.
          // Lesson 객체를 Command가 사용하는 목록에 저장한다.
          boardList.add(Board.valueOf(dataScan.nextLine()));

          count++;

        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d 개의 게시글 데이터를 로딩했습니다.\n", count);

    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
      // 파일에서 데이터를 읽다가 오류가 발생하더라도
      // 시스템을 멈추지 않고 계속 실행하게 한다.
      // 이것이 예외처리를 하는 이유이다!!!
    } finally {
      // 자원이 서로 연결된 경우에는 다른 자원을 이용하는 객체부터 닫는다.
      try {
        dataScan.close();
      } catch (Exception e) {
        // Scanner 객체 닫다가 오류가 발생하더라도 무시한다.
      }
      try {
        in.close();
      } catch (Exception e) {
        // close() 실행하다가 오류가 발생한 경우 무시한다.
        // 왜? 닫다가 발생한 오류는 특별히 처리할 게 없다.
      }
    }
  }



  private static void saveBoardData() {
    // 데이터가 보관된 파일을 정보를 준비한다.
    File file = new File("./board.csv");

    FileWriter out = null;

    try {
      // 파일에 데이터를 저장할 때 사용할 도구를 준비한다.
      out = new FileWriter(file);
      int count = 0;

      for (Board board : boardList) {

        // 데이터를 포맷후 줄바꿈을 더해 보드에 저장해서 파일로 저장한다
        out.write(board.toCsvString() + "\n");
        count++;
      }
      System.out.printf("총 %d 개의 게시글 데이터를 저장했습니다.\n", count);

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
        // FileWriter를 닫을 때 발생하는 예외는 무시한다.
      }
    }
  }


}



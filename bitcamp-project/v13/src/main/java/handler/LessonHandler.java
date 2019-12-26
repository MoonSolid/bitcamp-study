package handler;

import java.sql.Date;
import java.util.Scanner;
import domain.Lesson;

public class LessonHandler {


  //인스턴스 필드 = 논-스태틱 필드 
  //각 수업 목록을 개별적으로 관리
  Lesson[] lessons = new Lesson[LESSON_SIZE];  //LessonHandler의 인스턴스필드
  int lessonCount = 0;

  // 클래스 필드  = 스태틱 필드
  // -> 공유할 변수
  static final int LESSON_SIZE = 100;
  public static Scanner keyboard;


  public static void addLesson(LessonHandler lessonHandler) {  //파라미터로 인스턴스의 주소를받음
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.no = keyboard.nextInt();

    keyboard.nextLine(); 

    System.out.print("수업명? ");
    lesson.title = keyboard.nextLine();

    System.out.print("설명? ");
    lesson.description = keyboard.nextLine();

    System.out.print("시작일? ");
    lesson.startDate = Date.valueOf(keyboard.next());

    System.out.print("종료일? ");
    lesson.endDate = Date.valueOf(keyboard.next());

    System.out.print("총수업시간? ");
    lesson.totalHours = keyboard.nextInt();

    System.out.print("일수업시간? ");
    lesson.dayHours = keyboard.nextInt();
    keyboard.nextLine(); 

    lessonHandler.lessons[lessonHandler.lessonCount++] = lesson;
    System.out.println("저장하였습니다.");
  }


  public static void listLesson(LessonHandler lessonHandler) {

    for (int i = 0; i < lessonHandler.lessonCount; i++) {
      Lesson l = lessonHandler.lessons[i];
      System.out.printf("%d, %s, %s ~ %s, %d\n",
          l.no, l.title, l.startDate, l.endDate, l.totalHours);
    }
  }
}
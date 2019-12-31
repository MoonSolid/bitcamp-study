package handler;

import java.sql.Date;
import java.util.Scanner;
import domain.Lesson;

public class LessonHandler {


  
  LessonList lessonList; // lessonlist를 불러옴
  
  Scanner input;
  
 
  
  
  public LessonHandler(Scanner input) {  //입력받는 부분을 lessonlist에서 처리
    this.input = input;
    lessonList = new LessonList();
  }
  
  public LessonHandler(Scanner input, int capacity) {
    this.input = input;
    lessonList = new LessonList(capacity);
  }
  


  public void addLesson() {  //파라미터로 인스턴스의 주소를받음     
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(input.nextInt());

    input.nextLine(); 

    System.out.print("수업명? ");
    lesson.setTitle(input.nextLine());

    System.out.print("설명? ");
    lesson.setDescription(input.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(input.next()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(input.next()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(input.nextInt());

    System.out.print("일수업시간? ");
    lesson.setDayHours(input.nextInt());
    input.nextLine(); 

    lessonList.add(lesson);
    
    System.out.println("저장하였습니다.");
  }


  public void listLesson() {
    Lesson[] lessons = lessonList.toArray();
    for (Lesson l : lessons) {
      System.out.printf("%d, %s, %s ~ %s, %d\n",
          l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
      
    }
  }
}

package handler;

import java.sql.Date;
import java.util.Scanner;
import domain.Lesson;

public class LessonHandler {


  
  ArrayList lessonList; // lessonlist를 불러옴   //변경
  
  Scanner input;
  
 
  
  
  public LessonHandler(Scanner input) {  //입력받는 부분을 lessonlist에서 처리
    this.input = input;
    lessonList = new ArrayList();  //변경
  }
  
  public LessonHandler(Scanner input, int capacity) {
    this.input = input;
    lessonList = new ArrayList(capacity);  //변경
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
    Object[] arr = this.lessonList.toArray(); //변경
    for (Object obj : arr) {  //변경 
      Lesson l = (Lesson) obj;  //추가  , 형변환
      System.out.printf("%d, %s, %s ~ %s, %d\n",
          l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
      
    }
  }
}

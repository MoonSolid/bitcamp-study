package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;

public class LessonHandler {
  
  ArrayList<Lesson> lessonList;
  
  public Scanner input;
  
  public LessonHandler(Scanner input) {
    this.input = input;
    this.lessonList = new ArrayList<>();
  }
  
  public void listLesson() {
    
    Lesson[] arr = new Lesson[this.lessonList.size()];
    
    this.lessonList.toArray(arr);
    
    for (Lesson l : arr) {
      System.out.printf("%d, %s, %s ~ %s, %d\n",
          l.getNo(), l.getTitle(), 
          l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
  }
  
  public void addLesson() {
    Lesson lesson = new Lesson();
    
    System.out.print("번호? ");
    lesson.setNo(input.nextInt());

    input.nextLine(); 

    System.out.print("수업명? ");
    lesson.setTitle(input.nextLine());

    System.out.print("수업내용? ");
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
  
  
  public void detailLesson() {
    System.out.print("번호? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Lesson lesson = this.lessonList.get(index);

    if (lesson == null) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }

    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("수업내용: %s\n", lesson.getDescription());
    System.out.printf("기간: %s ~ %s \n", lesson.getStartDate(),lesson.getEndDate());
    System.out.printf("총수업시간: %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %d\n", lesson.getDayHours());
  }
  
  public void updateLesson() {
    System.out.print("번호?");
    int index = input.nextInt();
    input.nextLine();
    
    Lesson oldLesson = this.lessonList.get(index);
    
    if (oldLesson == null) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }
    
    
    System.out.printf("수업명(%s)? ",oldLesson.getTitle());
    String title = input.nextLine();
    
    System.out.printf("수업내용(%s)? ",oldLesson.getDescription());
    String description = input.nextLine();
    
    System.out.printf("시작일(%s)? ",oldLesson.getStartDate());
    String startDate = input.nextLine();
    
    System.out.printf("종료일(%s)? ",oldLesson.getEndDate());
    String endDate = input.nextLine();
    
    System.out.printf("총수업시간(%d)? ",oldLesson.getTotalHours());
    int totalHours = input.nextInt();
    input.nextLine();
    
    System.out.printf("수업명(%d)? ",oldLesson.getDayHours());
    int dayHours = input.nextInt();
    input.nextLine();
    
    if (title.length() == 0 && description.length() == 0 && 
        startDate.length() == 0 && endDate.length() == 0 &&
          totalHours == 0 && dayHours == 0) {
      System.out.println("수업 변경을 취소했습니다.");
      return;
    }
    
    Lesson newLesson = new Lesson();
    newLesson.setNo(oldLesson.getNo());
    newLesson.setTitle(title);
    newLesson.setDescription(description);
    newLesson.setStartDate(oldLesson.getStartDate());
    newLesson.setEndDate(oldLesson.getEndDate());
    newLesson.setTotalHours(totalHours);
    newLesson.setDayHours(dayHours);
    
    
    this.lessonList.set(index, newLesson);
    System.out.println("수업을 변경했습니다.");
  }
  
  public void deleteLesson() {
    System.out.print("번호 ? ");
    int index = input.nextInt();
    input.nextLine();
    
    Lesson lesson = this.lessonList.get(index);
    
    if (lesson == null) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }
    
    this.lessonList.remove(index);
    
    System.out.println("수업을 삭제했습니다.");
  }
  
}

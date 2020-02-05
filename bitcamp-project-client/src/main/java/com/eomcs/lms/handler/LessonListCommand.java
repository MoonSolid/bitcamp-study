package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

// "/lesson/list" 명령어 처리
public class LessonListCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;

  public LessonListCommand(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {
    try {
      out.writeUTF("/lesson/list");

      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      List<Lesson> lessons = (List<Lesson>) in.readObject();
      for (Lesson l : lessons) {
        System.out.printf("%d, %s, %s, %s, %s, %d, %d\n", l.getNo(), l.getTitle(), l.getDescription(),
            l.getStartDate(), l.getEndDate(), l.getTotalHours(), l.getDayHours());
      }

    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }
  }


}



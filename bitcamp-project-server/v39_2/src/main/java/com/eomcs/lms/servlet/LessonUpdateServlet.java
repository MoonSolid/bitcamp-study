package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonUpdateServlet implements Servlet {
  LessonDao lessonDao;

  public LessonUpdateServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    int no = Prompt.getInt(in, out, "번호? ");

    Lesson old = lessonDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 수업이 없습니다.");
      return;
    }

    Lesson lesson = new Lesson();

    lesson.setNo(no);


    lesson.setTitle(Prompt.getString(in, out, "수업명? "));
    lesson.setDescription(Prompt.getString(in, out, "설명? "));
    lesson.setStartDate(Prompt.getDate(in, out, "시작일? "));
    lesson.setEndDate(Prompt.getDate(in, out, "종료일? "));
    lesson.setTotalHours(Prompt.getInt(in, out, "총수업시간? "));
    lesson.setDayHours(Prompt.getInt(in, out, "일수업시간? "));

    if (lessonDao.update(lesson) > 0) {
      out.println("수업을 변경했습니다.");

    } else {
      out.println("수업 변경에 실패했습니다.");
    }
  }
}

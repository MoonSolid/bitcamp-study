package com.eomcs.lms.servlet;

<<<<<<< HEAD
import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonUpdateServlet implements Servlet {

  // DAO 클래스를 구체적으로 지정하기 보다는
  // 인터페이스를 지정함으로써
  // 향후 다른 구현체로 교체하기 쉽도록 한다.
  //
  LessonDao lessonDao;

  public LessonUpdateServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
=======
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@WebServlet("/lesson/update")
public class LessonUpdateServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    try {
      res.setContentType("text/html;charset=UTF-8");
      PrintWriter out = res.getWriter();

      ServletContext servletContext = req.getServletContext();
      ApplicationContext iocContainer =
          (ApplicationContext) servletContext.getAttribute("iocContainer");
      LessonService lessonService = iocContainer.getBean(LessonService.class);

      Lesson lesson = new Lesson();
      lesson.setNo(Integer.parseInt(req.getParameter("no")));
      lesson.setTitle(req.getParameter("title"));
      lesson.setDescription(req.getParameter("description"));
      lesson.setStartDate(Date.valueOf(req.getParameter("startDate")));
      lesson.setEndDate(Date.valueOf(req.getParameter("endDate")));
      lesson.setTotalHours(Integer.parseInt(req.getParameter("totalHours")));
      lesson.setDayHours(Integer.parseInt(req.getParameter("dayHours")));
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<meta http-equiv='refresh' content='2;url=list'>");
      out.println("<title>강의 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>강의 변경 결과</h1>");

<<<<<<< HEAD
    Lesson old = lessonDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 강의가 없습니다.");
      return;
    }

    Lesson lesson = new Lesson();

    lesson.setNo(no);
    lesson.setTitle(Prompt.getString(in, out, //
        String.format("강의명(%s)? \n", old.getTitle()), //
        old.getTitle()));
    lesson.setDescription(Prompt.getString(in, out, //
        String.format("내용(%s)? \n", old.getDescription()), //
        old.getDescription()));
    lesson.setStartDate(Prompt.getDate(in, out, //
        String.format("강의 시작일(%s)? \n", old.getStartDate()), //
        old.getStartDate().toString()));
    lesson.setEndDate(Prompt.getDate(in, out, //
        String.format("강의 종료일(%s)? \n", old.getEndDate()), //
        old.getEndDate().toString()));
    lesson.setTotalHours(Prompt.getInt(in, out, //
        String.format("총 강의시간(%d)? \n", old.getTotalHours()), //
        String.valueOf(old.getTotalHours())));
    lesson.setDayHours(Prompt.getInt(in, out, //
        String.format("일 강의시간(%d)? \n", old.getDayHours()), //
        String.valueOf(old.getDayHours())));

    if (lessonDao.update(lesson) > 0) {
      out.println("강의를 변경했습니다.");

    } else {
      out.println("변경에 실패했습니다.");
=======
      if (lessonService.update(lesson) > 0) {
        out.println("<p>강의를 변경했습니다.</p>");

      } else {
        out.println("<p>변경에 실패했습니다.</p>");
      }

      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03
    }
  }
}

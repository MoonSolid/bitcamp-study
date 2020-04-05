package com.eomcs.lms.servlet;

<<<<<<< HEAD
import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonAddServlet implements Servlet {

  LessonDao lessonDao;

  public LessonAddServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    Lesson lesson = new Lesson();

    lesson.setTitle(Prompt.getString(in, out, "강의명? "));
    lesson.setDescription(Prompt.getString(in, out, "내용? "));
    lesson.setStartDate(Prompt.getDate(in, out, "강의 시작일? "));
    lesson.setEndDate(Prompt.getDate(in, out, "강의 종료일? "));
    lesson.setTotalHours(Prompt.getInt(in, out, "총 강의시간? "));
    lesson.setDayHours(Prompt.getInt(in, out, "일 강의시간? "));

    if (lessonDao.insert(lesson) > 0) {
      out.println("강의를 저장했습니다.");

    } else {
      out.println("저장에 실패했습니다.");
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

@WebServlet("/lesson/add")
public class LessonAddServlet extends GenericServlet {
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
      lesson.setTitle(req.getParameter("title"));
      lesson.setDescription(req.getParameter("description"));
      lesson.setStartDate(Date.valueOf(req.getParameter("startDate")));
      lesson.setEndDate(Date.valueOf(req.getParameter("endDate")));
      lesson.setTotalHours(Integer.parseInt(req.getParameter("totalHours")));
      lesson.setDayHours(Integer.parseInt(req.getParameter("dayHours")));

      lessonService.add(lesson);

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<meta http-equiv='refresh' content='2;url=list'>");
      out.println("<title>강의 입력</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>강의 입력 결과</h1>");
      out.println("<p>새 강의를 등록했습니다.</p>");
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03
    }
  }
}

package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
<<<<<<< HEAD
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.util.Prompt;

public class PhotoBoardListServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  LessonDao lessonDao;

  public PhotoBoardListServlet(PhotoBoardDao photoBoardDao, LessonDao lessonDao) {
    this.photoBoardDao = photoBoardDao;
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    int lessonNo = Prompt.getInt(in, out, "수업번호? ");

    Lesson lesson = lessonDao.findByNo(lessonNo);
    if (lesson == null) {
      out.println("수업 번호가 유효하지 않습니다.");
      return;
    }
=======
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@WebServlet("/photoboard/list")
public class PhotoBoardListServlet extends GenericServlet {
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
      PhotoBoardService photoBoardService = iocContainer.getBean(PhotoBoardService.class);
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("  <meta charset='UTF-8'>");
      out.println("  <title>강의 사진 목록</title>");
      out.println("</head>");
      out.println("<body>");
      try {
        int lessonNo = Integer.parseInt(req.getParameter("lessonNo"));
        Lesson lesson = lessonService.get(lessonNo);
        if (lesson == null) {
          throw new Exception("수업 번호가 유효하지 않습니다.");
        }
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03

        out.printf("  <h1>강의 사진 - %s</h1>", lesson.getTitle());
        out.printf("  <a href='addForm?lessonNo=%d'>새 사진</a><br>\n", //
            lessonNo);
        out.println("  <table border='1'>");
        out.println("  <tr>");
        out.println("    <th>번호</th>");
        out.println("    <th>제목</th>");
        out.println("    <th>등록일</th>");
        out.println("    <th>조회수</th>");
        out.println("  </tr>");

<<<<<<< HEAD
    List<PhotoBoard> photoBoards = photoBoardDao.findAllByLessonNo(lessonNo);
=======
        List<PhotoBoard> photoBoards = photoBoardService.listLessonPhoto(lessonNo);
        for (PhotoBoard photoBoard : photoBoards) {
          out.printf("  <tr>"//
              + "<td>%d</td> "//
              + "<td><a href='detail?no=%d'>%s</a></td> "//
              + "<td>%s</td> "//
              + "<td>%d</td>"//
              + "</tr>\n", //
              photoBoard.getNo(), //
              photoBoard.getNo(), //
              photoBoard.getTitle(), //
              photoBoard.getCreatedDate(), //
              photoBoard.getViewCount() //
          );
        }
        out.println("</table>");
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03

      } catch (Exception e) {
        out.printf("<p>%s</p>\n", e.getMessage());
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.sql.PlatformTransactionManager;
import com.eomcs.util.Prompt;

public class PhotoBoardAddServlet implements Servlet {

  PlatformTransactionManager txManager;
  PhotoBoardDao photoBoardDao;
  LessonDao lessonDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardAddServlet( //
      PlatformTransactionManager txManager, //
      PhotoBoardDao photoBoardDao, //
      LessonDao lessonDao, //
      PhotoFileDao photoFileDao) {
    this.txManager = txManager;
    this.photoBoardDao = photoBoardDao;
    this.lessonDao = lessonDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setTitle(Prompt.getString(in, out, "제목? "));
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
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@WebServlet("/photoboard/add")
public class PhotoBoardAddServlet extends GenericServlet {
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
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03

      int lessonNo = Integer.parseInt(req.getParameter("lessonNo"));
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<meta http-equiv='refresh'" //
          + " content='2;url=list?lessonNo=" + lessonNo + "'>");
      out.println("<title>사진 입력</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>사진 입력 결과</h1>");

<<<<<<< HEAD
    Lesson lesson = lessonDao.findByNo(lessonNo);
    if (lesson == null) {
      out.println("수업 번호가 유효하지 않습니다.");
      return;
    }

    photoBoard.setLesson(lesson);

    txManager.beginTransaction();

    try {
      if (photoBoardDao.insert(photoBoard) == 0) {
        throw new Exception("사진 게시글 등록에 실패했습니다.");
      }
      List<PhotoFile> photoFiles = inputPhotoFiles(in, out);
      for (PhotoFile photoFile : photoFiles) {
        photoFile.setBoardNo(photoBoard.getNo());
        photoFileDao.insert(photoFile);
      }
      txManager.commit();
      out.println("새 사진 게시글을 등록했습니다.");

    } catch (Exception e) {
      txManager.rollback();
      out.println(e.getMessage());
    }
  }
=======
      try {
        Lesson lesson = lessonService.get(lessonNo);
        if (lesson == null) {
          throw new Exception("수업 번호가 유효하지 않습니다.");
        }

        PhotoBoard photoBoard = new PhotoBoard();
        photoBoard.setTitle(req.getParameter("title"));
        photoBoard.setLesson(lesson);

        ArrayList<PhotoFile> photoFiles = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
          String filepath = req.getParameter("photo" + i);
          if (filepath.length() > 0) {
            photoFiles.add(new PhotoFile().setFilepath(filepath));
          }
        }
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03

        if (photoFiles.size() == 0) {
          throw new Exception("최소 한 개의 사진 파일을 등록해야 합니다.");
        }

        photoBoard.setFiles(photoFiles);
        photoBoardService.add(photoBoard);

        out.println("<p>새 사진 게시글을 등록했습니다.</p>");

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

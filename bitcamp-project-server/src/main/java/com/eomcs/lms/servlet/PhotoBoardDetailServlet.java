package com.eomcs.lms.servlet;

<<<<<<< HEAD
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.util.Prompt;

public class PhotoBoardDetailServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardDetailServlet( //
      PhotoBoardDao photoBoardDao, //
      PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "사진 게시글 번호? ");

    PhotoBoard photoBoard = photoBoardDao.findByNo(no);
=======
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@WebServlet("/photoboard/detail")
public class PhotoBoardDetailServlet extends GenericServlet {
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
      PhotoBoardService photoBoardService = iocContainer.getBean(PhotoBoardService.class);
      int no = Integer.parseInt(req.getParameter("no"));

      PhotoBoard photoBoard = photoBoardService.get(no);

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>사진 상세정보</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>사진 상세정보</h1>");
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03

      if (photoBoard != null) {
        out.println("<form action='update'>");
        out.printf("번호: <input name='no' type='text' readonly value='%d'><br>\n", //
            photoBoard.getNo());
        out.println("내용:<br>");
        out.printf("<textarea name='title' rows='5' cols='60'>%s</textarea><br>\n", //
            photoBoard.getTitle());
        out.printf("등록일: %s<br>\n", photoBoard.getCreatedDate());
        out.printf("조회수: %d<br>\n", photoBoard.getViewCount());
        out.printf("수업: %s<br>\n", photoBoard.getLesson().getTitle());
        out.println("<hr>");
        out.println("사진 파일:<br>");
        out.println("<ul>\n");
        for (PhotoFile photoFile : photoBoard.getFiles()) {
          out.printf("  <li>%s</li>\n", photoFile.getFilepath());
        }
        out.println("</ul>");

<<<<<<< HEAD
      List<PhotoFile> photoFiles = photoFileDao.findAll(photoBoard.getNo());
      for (PhotoFile photoFile : photoFiles) {
        out.printf("> %s\n", photoFile.getFilepath());
      }
=======
        out.println("사진: <input name='photo1' type='file'><br>");
        out.println("사진: <input name='photo2' type='file'><br>");
        out.println("사진: <input name='photo3' type='file'><br>");
        out.println("사진: <input name='photo4' type='file'><br>");
        out.println("사진: <input name='photo5' type='file'><br>");
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03

        out.println("<p><button>변경</button>");
        out.printf("<a href='delete?no=%d&lessonNo=%d'>삭제</a></p>\n", //
            photoBoard.getNo(), //
            photoBoard.getLesson().getNo());
        out.println("</form>");

      } else {
        out.println("<p>해당 번호의 사진 게시글이 없습니다.</p>");
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

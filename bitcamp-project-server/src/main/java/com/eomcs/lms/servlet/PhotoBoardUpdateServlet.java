package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.sql.PlatformTransactionManager;
import com.eomcs.util.Prompt;

public class PhotoBoardUpdateServlet implements Servlet {

  PlatformTransactionManager txManager;
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardUpdateServlet( //
      PlatformTransactionManager txManager, //
      PhotoBoardDao photoBoardDao, //
      PhotoFileDao photoFileDao) {
    this.txManager = txManager;
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    int no = Prompt.getInt(in, out, "번호? ");

    PhotoBoard old = photoBoardDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 사진 게시글이 없습니다.");
      return;
    }

    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setTitle(Prompt.getString(in, out, //
        String.format("제목(%s)? \n", old.getTitle()), //
        old.getTitle()));
    photoBoard.setNo(no);

    txManager.beginTransaction();

    try {
      if (photoBoardDao.update(photoBoard) == 0) {
        throw new Exception("사진 게시글 변경에 실패했습니다.");
      }

      printPhotoFiles(out, no);

      out.println();
      out.println("사진은 일부만 변경할 수 없습니다.");
      out.println("전체를 새로 등록해야 합니다.");

      String response = Prompt.getString(in, out, //
          "사진을 변경하시겠습니까?(y/N) ");

      if (response.equalsIgnoreCase("y")) {

        // 이 사진 게시글에 첨부되었은 기존 파일을 모두 삭제한다.
        photoFileDao.deleteAll(no);

        List<PhotoFile> photoFiles = inputPhotoFiles(in, out);

        for (PhotoFile photoFile : photoFiles) {
          photoFile.setBoardNo(no);
          photoFileDao.insert(photoFile);
        }
      }
      txManager.commit();
      out.println("사진 게시글을 변경했습니다.");

    } catch (Exception e) {
      txManager.rollback();
      out.println(e.getMessage());
    }
  }

  private void printPhotoFiles(PrintStream out, int boardNo) throws Exception {
    out.println("사진파일:");
    List<PhotoFile> oldPhotoFiles = photoFileDao.findAll(boardNo);
    for (PhotoFile photoFile : oldPhotoFiles) {
      out.printf("> %s\n", photoFile.getFilepath());
    }
  }

  private List<PhotoFile> inputPhotoFiles(Scanner in, PrintStream out) {
    // 첨부 파일을 입력 받는다.
    out.println("최소 한 개의 사진 파일을 등록해야 합니다.");
    out.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

    ArrayList<PhotoFile> photoFiles = new ArrayList<>();
=======
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

@WebServlet("/photoboard/update")
public class PhotoBoardUpdateServlet extends GenericServlet {
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
      photoBoard.setTitle(req.getParameter("title"));

      ArrayList<PhotoFile> photoFiles = new ArrayList<>();
      for (int i = 1; i <= 5; i++) {
        String filepath = req.getParameter("photo" + i);
        if (filepath.length() > 0) {
          photoFiles.add(new PhotoFile().setFilepath(filepath));
        }
      }
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03

      if (photoFiles.size() > 0) {
        photoBoard.setFiles(photoFiles);
      } else {
        photoBoard.setFiles(null);
      }

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.printf("<meta http-equiv='refresh' content='2;url=list?lessonNo=%d'>", //
          photoBoard.getLesson().getNo());
      out.println("<title>사진 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>사진 변경 결과</h1>");

      try {
        photoBoardService.update(photoBoard);
        out.println("<p>사진을 변경했습니다.</p>");
      } catch (Exception e) {
        out.println("<p>해당 사진 게시물이 존재하지 않습니다.</p>");
      }

      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

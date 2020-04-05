package com.eomcs.lms.servlet;

<<<<<<< HEAD
import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardDetailServlet implements Servlet {

  BoardDao boardDao;

  public BoardDetailServlet(BoardDao boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");

    Board board = boardDao.findByNo(no);
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
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@WebServlet("/board/detail")
public class BoardDetailServlet extends GenericServlet {
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
      BoardService boardService = iocContainer.getBean(BoardService.class);

      int no = Integer.parseInt(req.getParameter("no"));
      Board board = boardService.get(no);
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>게시글 상세정보</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>게시물 상세정보</h1>");
      if (board != null) {
        out.printf("번호: %d<br>\n", board.getNo());
        out.printf("제목: %s<br>\n", board.getTitle());
        out.printf("등록일: %s<br>\n", board.getDate());
        out.printf("조회수: %d<br>\n", board.getViewCount());
        out.printf("<p><a href='delete?no=%d'>삭제</a> \n", //
            board.getNo());
        out.printf("<a href='updateForm?no=%d'>변경</a></p>\n", //
            board.getNo());
      } else {
        out.println("<p>해당 번호의 게시물이 없습니다.</p>");
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

package com.eomcs.lms.servlet;

<<<<<<< HEAD
import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardUpdateServlet implements Servlet {

  BoardDao boardDao;

  public BoardUpdateServlet(BoardDao boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    int no = Prompt.getInt(in, out, "번호? ");

    Board old = boardDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    Board board = new Board();

    board.setTitle(Prompt.getString(//
        in, //
        out, //
        String.format("제목(%s)? \n", old.getTitle()), //
        old.getTitle()));

    board.setNo(no);

    if (boardDao.update(board) > 0) { // 변경했다면,
      out.println("게시글을 변경했습니다.");

    } else {
      out.println("게시글 변경에 실패했습니다.");
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

@WebServlet("/board/update")
public class BoardUpdateServlet extends GenericServlet {
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

      Board board = new Board();
      board.setNo(Integer.parseInt(req.getParameter("no")));
      board.setTitle(req.getParameter("title"));

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<meta http-equiv='refresh' content='2;url=list'>");
      out.println("<title>게시글 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>게시물 변경 결과</h1>");

      if (boardService.update(board) > 0) { // 변경했다면,
        out.println("<p>게시글을 변경했습니다.</p>");

      } else {
        out.println("<p>해당 번호의 게시글이 없습니다.</p>");
      }

      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03
    }
  }
}

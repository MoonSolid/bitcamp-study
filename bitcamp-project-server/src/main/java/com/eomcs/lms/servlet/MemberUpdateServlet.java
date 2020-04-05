package com.eomcs.lms.servlet;

<<<<<<< HEAD
import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberUpdateServlet implements Servlet {

  MemberDao memberDao;

  public MemberUpdateServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");

    Member old = memberDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    Member member = new Member();

    member.setNo(no);
    member.setName(Prompt.getString(in, out, //
        String.format("이름(%s)? \n", old.getName()), //
        old.getName()));
    member.setEmail(Prompt.getString(in, out, //
        String.format("이메일(%s)? \n", old.getEmail()), //
        old.getEmail()));
    member.setPassword(Prompt.getString(in, out, "암호? "));
    member.setPhoto(Prompt.getString(in, out, //
        String.format("사진(%s)? \n", old.getPhoto()), //
        old.getPhoto()));
    member.setTel(Prompt.getString(in, out, //
        String.format("전화(%s)? \n", old.getTel()), //
        old.getTel()));

    if (memberDao.update(member) > 0) {
      out.println("회원을 변경했습니다.");

    } else {
      out.println("변경에 실패했습니다.");
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
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@WebServlet("/member/update")
public class MemberUpdateServlet extends GenericServlet {
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
      MemberService memberService = iocContainer.getBean(MemberService.class);

      Member member = new Member();
      member.setNo(Integer.parseInt(req.getParameter("no")));
      member.setName(req.getParameter("name"));
      member.setEmail(req.getParameter("email"));
      member.setPassword(req.getParameter("password"));
      member.setPhoto(req.getParameter("photo"));
      member.setTel(req.getParameter("tel"));

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<meta http-equiv='refresh' content='2;url=list'>");
      out.println("<title>회원 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>회원 변경 결과</h1>");

      if (memberService.update(member) > 0) {
        out.println("<p>회원을 변경했습니다.</p>");

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

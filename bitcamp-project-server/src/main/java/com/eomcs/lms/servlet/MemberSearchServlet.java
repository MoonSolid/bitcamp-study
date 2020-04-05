package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
<<<<<<< HEAD
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberSearchServlet implements Servlet {

  MemberDao memberDao;

  public MemberSearchServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    String keyword = Prompt.getString(in, out, "검색어? ");

    List<Member> members = memberDao.findByKeyword(keyword);
    for (Member m : members) {
      out.printf("%d, %s, %s, %s, %s\n", //
          m.getNo(), //
          m.getName(), //
          m.getEmail(), //
          m.getTel(), //
          m.getRegisteredDate());
=======
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@WebServlet("/member/search")
public class MemberSearchServlet extends GenericServlet {
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

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("  <meta charset='UTF-8'>");
      out.println("  <title>회원 검색</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("  <h1>회원 검색 결과</h1>");
      out.println("  <table border='1'>");
      out.println("  <tr>");
      out.println("    <th>번호</th>");
      out.println("    <th>이름</th>");
      out.println("    <th>이메일</th>");
      out.println("    <th>전화</th>");
      out.println("    <th>등록일</th>");
      out.println("  </tr>");

      String keyword = req.getParameter("keyword");
      List<Member> members = memberService.search(keyword);
      for (Member m : members) {
        out.printf("  <tr>"//
            + "<td>%d</td> "//
            + "<td><a href='detail?no=%d'>%s</a></td> "//
            + "<td>%s</td> "//
            + "<td>%s</td>"//
            + "<td>%s</td>"//
            + "</tr>\n", //
            m.getNo(), //
            m.getNo(), //
            m.getName(), //
            m.getEmail(), //
            m.getTel(), //
            m.getRegisteredDate() //
        );
      }
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03
    }
  }
}

package storage;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.portfoli.domain.JobPosting;
import com.portfoli.service.JobPostingService;

@Controller
public class JobPostingController {

  @Autowired
  JobPostingService jobPostingService;

  @RequestMapping("/jobposting/form")
  public String form() throws Exception {
    return "/jobposting/form.jsp";
  }

  @RequestMapping("/jobposting/add")
  public String add(JobPosting jobPosting) throws Exception {
    jobPostingService.add(jobPosting);
    return "redirect:list";
  }

  @RequestMapping("/jobposting/delete")
  public String delete(int no) throws Exception {
    if (jobPostingService.delete(no) > 0) {
      return "redirect:list";
    } else {
      throw new Exception("삭제할 게시글 번호가 유효하지 않습니다.");
    }
  }

  @RequestMapping("/jobposting/detail")
  public String detail(int no, Map<String, Object> model) throws Exception {
    JobPosting jobPosting = jobPostingService.get(no);
    model.put("jobPosting", jobPosting);
    return "/jobposting/detail.jsp";
  }

  @RequestMapping("/jobposting/list")
  public String list(Map<String, Object> model) throws Exception {
    List<JobPosting> jobPostings = jobPostingService.list();
    model.put("list", jobPostings);
    return "/jobposting/list.jsp";
  }


  @RequestMapping("/jobposting/updateForm")
  public String updateForm(int no, Map<String, Object> model) throws Exception {
    model.put("jobPosting", jobPostingService.get(no));
    return "/jobPosting/updateform.jsp";
  }


  @RequestMapping("/jobposting/update")
  public String update(JobPosting jobPosting) throws Exception {
    if (jobPostingService.update(jobPosting) > 0) {
      return "redirect:list";
    } else {
      throw new Exception("변경할 게시글 번호가 유효하지 않습니다.");
    }
  }
}

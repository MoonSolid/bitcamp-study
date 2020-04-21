package test;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.portfoli.domain.JobPosting;
import com.portfoli.service.JobPostingService;

@Controller
@RequestMapping("/jobposting")
public class JobPostingController {

  static Logger logger = LogManager.getLogger(JobPostingController.class);

  @Autowired
  JobPostingService jobPostingService;

  public JobPostingController() {
    logger.debug("JobPostingController 생성");
  }

  @GetMapping("form")
  public void form() throws Exception {}

  @PostMapping("add")
  public String add(JobPosting jobPosting) throws Exception {
    jobPostingService.add(jobPosting);
    return "redirect:list";
  }

  @GetMapping("delete")
  public String delete(int no) throws Exception {
    if (jobPostingService.delete(no) > 0) {
      return "redirect:list";
    } else {
      throw new Exception("삭제할 게시글 번호가 유효하지 않습니다.");
    }
  }

  @GetMapping("detail")
  public void detail(int no, Model model) throws Exception {
    JobPosting jobPosting = jobPostingService.get(no);
    model.addAttribute("jobPosting", jobPosting);
  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    List<JobPosting> jobPostings = jobPostingService.list();
    model.addAttribute("list", jobPostings);
  }


  @GetMapping("updateForm")
  public void updateForm(int no, Model model) throws Exception {
    model.addAttribute("jobPosting", jobPostingService.get(no));
  }


  @PostMapping("update")
  public String update(JobPosting jobPosting) throws Exception {
    if (jobPostingService.update(jobPosting) > 0) {
      return "redirect:list";
    } else {
      throw new Exception("변경할 게시글 번호가 유효하지 않습니다.");
    }
  }
}

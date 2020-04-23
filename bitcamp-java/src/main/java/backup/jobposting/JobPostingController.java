package backup.jobposting;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.portfoli.domain.JobPosting;
import com.portfoli.domain.JobPostingFile;
import com.portfoli.service.JobPostingService;

@Controller
@RequestMapping("/jobposting")
public class JobPostingController {

  static Logger logger = LogManager.getLogger(JobPostingController.class);

  @Autowired
  ServletContext servletContext;

  @Autowired
  JobPostingService jobPostingService;

  public JobPostingController() {
    logger.debug("JobPostingController 생성");
  }

  @GetMapping("form")
  public void form(int jobPostingNumber, Model model) throws Exception {
    model.addAttribute("jobposting", jobPostingService.get(jobPostingNumber));
  }

  @PostMapping("add")
  public String add(//
      int jobPostingNumber, //
      String title, //
      MultipartFile[] jobPostingFiles) throws Exception {
    JobPosting jobPosting = jobPostingService.get(jobPostingNumber);
    if (jobPosting == null) {
      throw new Exception("공고 번호가 유효하지 않습니다.");
    }

    jobPosting = new JobPosting();
    jobPosting.setTitle(title);

    ArrayList<JobPostingFile> files = new ArrayList<>();
    String dirPath = servletContext.getRealPath("/upload/jobposting");
    for (MultipartFile jobPostingFile : jobPostingFiles) {
      if (jobPostingFile.getSize() <= 0) {
        continue;
      }
      String filename = UUID.randomUUID().toString();
      jobPostingFile.transferTo(new File(dirPath + "/" + filename));
      files.add(new JobPostingFile().setFilePath(filename));
    }

    jobPosting.setFiles(files);
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
  public String update(//
      int jobPostingNumber, //
      String title, //
      MultipartFile[] jobPostingFiles) throws Exception {

    JobPosting jobPosting = jobPostingService.get(jobPostingNumber);
    jobPosting.setTitle(title);

    ArrayList<JobPostingFile> files = new ArrayList<>();
    String dirPath = servletContext.getRealPath("/upload/jobposting");
    for (MultipartFile jobPostingFile : jobPostingFiles) {
      if (jobPostingFile.getSize() <= 0) {
        continue;
      }
      String filename = UUID.randomUUID().toString();
      jobPostingFile.transferTo(new File(dirPath + "/" + filename));
      files.add(new JobPostingFile().setFilePath(filename));
    }

    if (files.size() > 0) {
      jobPosting.setFiles(files);
    } else {
      jobPosting.setFiles(null);
    }


    jobPostingService.update(jobPosting);
    return "redirect:list";
  }
}

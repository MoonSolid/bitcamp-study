package backup.jobposting;

import java.util.List;
import org.springframework.stereotype.Component;
import com.portfoli.dao.JobPostingDao;
import com.portfoli.domain.JobPosting;
import com.portfoli.service.JobPostingService;

@Component
public class JobPostingServiceImpl implements JobPostingService {

  JobPostingDao jobPostingDao;

  public JobPostingServiceImpl(JobPostingDao jobPostingDao) {
    this.jobPostingDao = jobPostingDao;
  }

  @Override
  public void add(JobPosting jobPosting) throws Exception {
    jobPostingDao.insert(jobPosting);
  }

  @Override
  public List<JobPosting> list() throws Exception {
    return jobPostingDao.findAll();
  }

  @Override
  public int delete(int no) throws Exception {
    return jobPostingDao.delete(no);
  }

  @Override
  public JobPosting get(int no) throws Exception {
    return jobPostingDao.findByNo(no);
  }

  @Override
  public int update(JobPosting jobPosting) throws Exception {
    return jobPostingDao.update(jobPosting);
  }

}

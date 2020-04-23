package backup.jobposting;

import java.util.List;
import com.portfoli.domain.JobPosting;

public interface JobPostingService {

  void add(JobPosting jobPosting) throws Exception;

  List<JobPosting> list() throws Exception;

  int delete(int no) throws Exception;

  JobPosting get(int no) throws Exception;

  int update(JobPosting jobPosting) throws Exception;

}

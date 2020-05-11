package zzzzzzzz;

import java.util.List;
import com.portfoli.domain.JobPosting;

public interface JobPostingService {

  void add(JobPosting jobPosting) throws Exception;

  List<JobPosting> list() throws Exception;

  List<JobPosting> list2(int lastNo) throws Exception;

  void delete(int no) throws Exception;

  JobPosting get(int no) throws Exception;

  List<JobPosting> search(String keyword) throws Exception;

  void update(JobPosting jobPosting) throws Exception;

  int plusCnt(int jobPostingNumber) throws Exception;

}

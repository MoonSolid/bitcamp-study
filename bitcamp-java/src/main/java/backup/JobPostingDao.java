package backup;

import java.util.List;
import com.portfoli.domain.JobPosting;

public interface JobPostingDao {

  public int insert(JobPosting jobPosting) throws Exception;

  public List<JobPosting> findAll() throws Exception;

  public JobPosting findByNo(int no) throws Exception;

  public int update(JobPosting jobPosting) throws Exception;

  public int delete(int no) throws Exception;

  List<JobPosting> findByKeyword(String keyword) throws Exception;

}

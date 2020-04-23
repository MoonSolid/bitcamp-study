package backup.jobposting;

import java.util.List;
import com.portfoli.domain.JobPostingFile;

public interface JobPostingFileDao {

  public int insert(JobPostingFile jobPostingFile) throws Exception;

  List<JobPostingFile> findAll(int jobPostingNumber) throws Exception;

  int deleteAll(int jobPostingNumber) throws Exception;

}

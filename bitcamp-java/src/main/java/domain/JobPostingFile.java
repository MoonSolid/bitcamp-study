package domain;

import java.io.Serializable;

public class JobPostingFile implements Serializable {
  private static final long serialVersionUID = 1L;

  private int jobPostingFileNo;
  private int jobPostingNo;
  private String filePath;

  @Override
  public String toString() {
    return "JobPostingFile [jobPostingFileNo=" + jobPostingFileNo + ", jobPostingNo=" + jobPostingNo
        + ", filePath=" + filePath + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
    result = prime * result + jobPostingFileNo;
    result = prime * result + jobPostingNo;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    JobPostingFile other = (JobPostingFile) obj;
    if (filePath == null) {
      if (other.filePath != null)
        return false;
    } else if (!filePath.equals(other.filePath))
      return false;
    if (jobPostingFileNo != other.jobPostingFileNo)
      return false;
    if (jobPostingNo != other.jobPostingNo)
      return false;
    return true;
  }

  public int getJobPostingFileNo() {
    return jobPostingFileNo;
  }

  public void setJobPostingFileNo(int jobPostingFileNo) {
    this.jobPostingFileNo = jobPostingFileNo;
  }

  public int getJobPostingNo() {
    return jobPostingNo;
  }

  public void setJobPostingNo(int jobPostingNo) {
    this.jobPostingNo = jobPostingNo;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

}

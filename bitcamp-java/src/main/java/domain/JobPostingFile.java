package domain;

import java.io.Serializable;

public class JobPostingFile implements Serializable {
  private static final long serialVersionUID = 1L;

  private int jobPostingFileNumber;
  private int jobPostingNumber;
  private String filePath;

  @Override
  public String toString() {
    return "JobPostingFile [jobPostingFileNumber=" + jobPostingFileNumber + ", jobPostingNumber="
        + jobPostingNumber + ", filePath=" + filePath + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
    result = prime * result + jobPostingFileNumber;
    result = prime * result + jobPostingNumber;
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
    if (jobPostingFileNumber != other.jobPostingFileNumber)
      return false;
    if (jobPostingNumber != other.jobPostingNumber)
      return false;
    return true;
  }

  public int getJobPostingFileNumber() {
    return jobPostingFileNumber;
  }

  public void setJobPostingFileNumber(int jobPostingFileNumber) {
    this.jobPostingFileNumber = jobPostingFileNumber;
  }

  public int getJobPostingNumber() {
    return jobPostingNumber;
  }

  public void setJobPostingNumber(int jobPostingNumber) {
    this.jobPostingNumber = jobPostingNumber;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

}

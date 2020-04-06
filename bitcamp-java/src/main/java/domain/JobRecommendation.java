package domain;

import java.io.Serializable;

public class JobRecommendation implements Serializable {
  private static final long serialVersionUID = 1L;

  private int generalMemberNo;
  private int jobPostingNo;

  @Override
  public String toString() {
    return "JobRecommendation [generalMemberNo=" + generalMemberNo + ", jobPostingNo="
        + jobPostingNo + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + generalMemberNo;
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
    JobRecommendation other = (JobRecommendation) obj;
    if (generalMemberNo != other.generalMemberNo)
      return false;
    if (jobPostingNo != other.jobPostingNo)
      return false;
    return true;
  }

  public int getGeneralMemberNo() {
    return generalMemberNo;
  }

  public void setGeneralMemberNo(int generalMemberNo) {
    this.generalMemberNo = generalMemberNo;
  }

  public int getJobPostingNo() {
    return jobPostingNo;
  }

  public void setJobPostingNo(int jobPostingNo) {
    this.jobPostingNo = jobPostingNo;
  }
}

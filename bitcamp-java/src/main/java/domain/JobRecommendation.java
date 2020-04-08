package domain;

import java.io.Serializable;

public class JobRecommendation implements Serializable {
  private static final long serialVersionUID = 1L;

  private int generalMemberNumber;
  private int jobPostingNumber;

  @Override
  public String toString() {
    return "JobRecommendation [generalMemberNumber=" + generalMemberNumber + ", jobPostingNumber="
        + jobPostingNumber + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + generalMemberNumber;
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
    JobRecommendation other = (JobRecommendation) obj;
    if (generalMemberNumber != other.generalMemberNumber)
      return false;
    if (jobPostingNumber != other.jobPostingNumber)
      return false;
    return true;
  }

  public int getGeneralMemberNumber() {
    return generalMemberNumber;
  }

  public void setGeneralMemberNumber(int generalMemberNumber) {
    this.generalMemberNumber = generalMemberNumber;
  }

  public int getJobPostingNumber() {
    return jobPostingNumber;
  }

  public void setJobPostingNumber(int jobPostingNumber) {
    this.jobPostingNumber = jobPostingNumber;
  }
}

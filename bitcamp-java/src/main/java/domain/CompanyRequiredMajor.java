package domain;

import java.io.Serializable;

public class CompanyRequiredMajor implements Serializable {
  private static final long serialVersionUID = 1L;

  private int majorNumber;
  private int jobPostingNumber;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + jobPostingNumber;
    result = prime * result + majorNumber;
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
    CompanyRequiredMajor other = (CompanyRequiredMajor) obj;
    if (jobPostingNumber != other.jobPostingNumber)
      return false;
    if (majorNumber != other.majorNumber)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "CompanyRequiredMajor [majorNumber=" + majorNumber + ", jobPostingNumber="
        + jobPostingNumber + "]";
  }

  public int getMajorNumber() {
    return majorNumber;
  }

  public void setMajorNumber(int majorNumber) {
    this.majorNumber = majorNumber;
  }

  public int getJobPostingNumber() {
    return jobPostingNumber;
  }

  public void setJobPostingNumber(int jobPostingNumber) {
    this.jobPostingNumber = jobPostingNumber;
  }


}

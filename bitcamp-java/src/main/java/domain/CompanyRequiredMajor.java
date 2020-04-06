package domain;

import java.io.Serializable;

public class CompanyRequiredMajor implements Serializable {
  private static final long serialVersionUID = 1L;

  private int majorNo;
  private int jobPostingNo;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + jobPostingNo;
    result = prime * result + majorNo;
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
    if (jobPostingNo != other.jobPostingNo)
      return false;
    if (majorNo != other.majorNo)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "CompanyRequiredMajor [majorNo=" + majorNo + ", jobPostingNo=" + jobPostingNo + "]";
  }

  public int getMajorNo() {
    return majorNo;
  }

  public void setMajorNo(int majorNo) {
    this.majorNo = majorNo;
  }

  public int getJobPostingNo() {
    return jobPostingNo;
  }

  public void setJobPostingNo(int jobPostingNo) {
    this.jobPostingNo = jobPostingNo;
  }


}

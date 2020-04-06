package domain;

import java.io.Serializable;

public class CompanyRequiredCertificate implements Serializable {
  private static final long serialVersionUID = 1L;

  private int certificateNo;
  private int jobPostingNo;

  @Override
  public String toString() {
    return "CompanyRequiredCertificate [certificateNo=" + certificateNo + ", jobPostingNo="
        + jobPostingNo + "]";
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + certificateNo;
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
    CompanyRequiredCertificate other = (CompanyRequiredCertificate) obj;
    if (certificateNo != other.certificateNo)
      return false;
    if (jobPostingNo != other.jobPostingNo)
      return false;
    return true;
  }



  public int getCertificateNo() {
    return certificateNo;
  }

  public void setCertificateNo(int certificateNo) {
    this.certificateNo = certificateNo;
  }

  public int getJobPostingNo() {
    return jobPostingNo;
  }

  public void setJobPostingNo(int jobPostingNo) {
    this.jobPostingNo = jobPostingNo;
  }

}

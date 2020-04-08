package domain;

import java.io.Serializable;
import java.sql.Date;

public class JobPosting implements Serializable {
  private static final long serialVersionUID = 1L;

  private int jobPostingNumber;
  private int boardNumber;
  private int companyMemberNumber;
  private int workPlaceNumber;
  private int minimumCareer;
  private Date startDated;
  private Date endDated;
  private String job;
  private String thumnail;
  private int yearSalary;
  private int readable;
  private int minimumEducationNumber;
  private int employmentStatNumber;

  @Override
  public String toString() {
    return "JobPosting [jobPostingNumber=" + jobPostingNumber + ", boardNumber=" + boardNumber
        + ", companyMemberNumber=" + companyMemberNumber + ", workPlaceNumber=" + workPlaceNumber
        + ", minimumCareer=" + minimumCareer + ", startDated=" + startDated + ", endDated="
        + endDated + ", job=" + job + ", thumnail=" + thumnail + ", yearSalary=" + yearSalary
        + ", readable=" + readable + ", minimumEducationNumber=" + minimumEducationNumber
        + ", employmentStatNumber=" + employmentStatNumber + "]";
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + boardNumber;
    result = prime * result + companyMemberNumber;
    result = prime * result + employmentStatNumber;
    result = prime * result + ((endDated == null) ? 0 : endDated.hashCode());
    result = prime * result + ((job == null) ? 0 : job.hashCode());
    result = prime * result + jobPostingNumber;
    result = prime * result + minimumCareer;
    result = prime * result + minimumEducationNumber;
    result = prime * result + readable;
    result = prime * result + ((startDated == null) ? 0 : startDated.hashCode());
    result = prime * result + ((thumnail == null) ? 0 : thumnail.hashCode());
    result = prime * result + workPlaceNumber;
    result = prime * result + yearSalary;
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
    JobPosting other = (JobPosting) obj;
    if (boardNumber != other.boardNumber)
      return false;
    if (companyMemberNumber != other.companyMemberNumber)
      return false;
    if (employmentStatNumber != other.employmentStatNumber)
      return false;
    if (endDated == null) {
      if (other.endDated != null)
        return false;
    } else if (!endDated.equals(other.endDated))
      return false;
    if (job == null) {
      if (other.job != null)
        return false;
    } else if (!job.equals(other.job))
      return false;
    if (jobPostingNumber != other.jobPostingNumber)
      return false;
    if (minimumCareer != other.minimumCareer)
      return false;
    if (minimumEducationNumber != other.minimumEducationNumber)
      return false;
    if (readable != other.readable)
      return false;
    if (startDated == null) {
      if (other.startDated != null)
        return false;
    } else if (!startDated.equals(other.startDated))
      return false;
    if (thumnail == null) {
      if (other.thumnail != null)
        return false;
    } else if (!thumnail.equals(other.thumnail))
      return false;
    if (workPlaceNumber != other.workPlaceNumber)
      return false;
    if (yearSalary != other.yearSalary)
      return false;
    return true;
  }

  public int getJobPostingNumber() {
    return jobPostingNumber;
  }


  public void setJobPostingNumber(int jobPostingNumber) {
    this.jobPostingNumber = jobPostingNumber;
  }


  public int getBoardNumber() {
    return boardNumber;
  }


  public void setBoardNumber(int boardNumber) {
    this.boardNumber = boardNumber;
  }


  public int getCompanyMemberNumber() {
    return companyMemberNumber;
  }


  public void setCompanyMemberNumber(int companyMemberNumber) {
    this.companyMemberNumber = companyMemberNumber;
  }


  public int getWorkPlaceNumber() {
    return workPlaceNumber;
  }


  public void setWorkPlaceNumber(int workPlaceNumber) {
    this.workPlaceNumber = workPlaceNumber;
  }


  public int getMinimumCareer() {
    return minimumCareer;
  }


  public void setMinimumCareer(int minimumCareer) {
    this.minimumCareer = minimumCareer;
  }


  public Date getStartDated() {
    return startDated;
  }


  public void setStartDated(Date startDated) {
    this.startDated = startDated;
  }


  public Date getEndDated() {
    return endDated;
  }


  public void setEndDated(Date endDated) {
    this.endDated = endDated;
  }


  public String getJob() {
    return job;
  }


  public void setJob(String job) {
    this.job = job;
  }


  public String getThumnail() {
    return thumnail;
  }


  public void setThumnail(String thumnail) {
    this.thumnail = thumnail;
  }


  public int getYearSalary() {
    return yearSalary;
  }


  public void setYearSalary(int yearSalary) {
    this.yearSalary = yearSalary;
  }


  public int getReadable() {
    return readable;
  }


  public void setReadable(int readable) {
    this.readable = readable;
  }


  public int getMinimumEducationNumber() {
    return minimumEducationNumber;
  }


  public void setMinimumEducationNumber(int minimumEducationNumber) {
    this.minimumEducationNumber = minimumEducationNumber;
  }


  public int getEmploymentStatNumber() {
    return employmentStatNumber;
  }


  public void setEmploymentStatNumber(int employmentStatNumber) {
    this.employmentStatNumber = employmentStatNumber;
  }


}

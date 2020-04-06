package domain;

import java.io.Serializable;
import java.sql.Date;

public class JobPosting implements Serializable {
  private static final long serialVersionUID = 1L;

  private int jobPostingNo;
  private int companyMemberNo;
  private String title;
  private String content;
  private int workPlaceNo;
  private int minimumCareer;
  private int viewCount;
  private Date postingRegistion;
  private Date startDated;
  private Date endDated;
  private String job;
  private String thumnail;
  private int yearSalary;
  private int readable;
  private int minimumEducationNo;
  private int employmentStatNo;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + companyMemberNo;
    result = prime * result + ((content == null) ? 0 : content.hashCode());
    result = prime * result + employmentStatNo;
    result = prime * result + ((endDated == null) ? 0 : endDated.hashCode());
    result = prime * result + ((job == null) ? 0 : job.hashCode());
    result = prime * result + jobPostingNo;
    result = prime * result + minimumCareer;
    result = prime * result + minimumEducationNo;
    result = prime * result + ((postingRegistion == null) ? 0 : postingRegistion.hashCode());
    result = prime * result + readable;
    result = prime * result + ((startDated == null) ? 0 : startDated.hashCode());
    result = prime * result + ((thumnail == null) ? 0 : thumnail.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + viewCount;
    result = prime * result + workPlaceNo;
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
    if (companyMemberNo != other.companyMemberNo)
      return false;
    if (content == null) {
      if (other.content != null)
        return false;
    } else if (!content.equals(other.content))
      return false;
    if (employmentStatNo != other.employmentStatNo)
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
    if (jobPostingNo != other.jobPostingNo)
      return false;
    if (minimumCareer != other.minimumCareer)
      return false;
    if (minimumEducationNo != other.minimumEducationNo)
      return false;
    if (postingRegistion == null) {
      if (other.postingRegistion != null)
        return false;
    } else if (!postingRegistion.equals(other.postingRegistion))
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
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (viewCount != other.viewCount)
      return false;
    if (workPlaceNo != other.workPlaceNo)
      return false;
    if (yearSalary != other.yearSalary)
      return false;
    return true;
  }



  @Override
  public String toString() {
    return "JobPosting [jobPostingNo=" + jobPostingNo + ", companyMemberNo=" + companyMemberNo
        + ", title=" + title + ", content=" + content + ", workPlaceNo=" + workPlaceNo
        + ", minimumCareer=" + minimumCareer + ", viewCount=" + viewCount + ", postingRegistion="
        + postingRegistion + ", startDated=" + startDated + ", endDated=" + endDated + ", job="
        + job + ", thumnail=" + thumnail + ", yearSalary=" + yearSalary + ", readable=" + readable
        + ", minimumEducationNo=" + minimumEducationNo + ", employmentStatNo=" + employmentStatNo
        + "]";
  }


  public int getJobPostingNo() {
    return jobPostingNo;
  }

  public void setJobPostingNo(int jobPostingNo) {
    this.jobPostingNo = jobPostingNo;
  }

  public int getCompanyMemberNo() {
    return companyMemberNo;
  }

  public void setCompanyMemberNo(int companyMemberNo) {
    this.companyMemberNo = companyMemberNo;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getWorkPlaceNo() {
    return workPlaceNo;
  }

  public void setWorkPlaceNo(int workPlaceNo) {
    this.workPlaceNo = workPlaceNo;
  }

  public int getMinimumCareer() {
    return minimumCareer;
  }

  public void setMinimumCareer(int minimumCareer) {
    this.minimumCareer = minimumCareer;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public Date getPostingRegistion() {
    return postingRegistion;
  }

  public void setPostingRegistion(Date postingRegistion) {
    this.postingRegistion = postingRegistion;
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

  public int getMinimumEducationNo() {
    return minimumEducationNo;
  }

  public void setMinimumEducationNo(int minimumEducationNo) {
    this.minimumEducationNo = minimumEducationNo;
  }

  public int getEmploymentStatNo() {
    return employmentStatNo;
  }

  public void setEmploymentStatNo(int employmentStatNo) {
    this.employmentStatNo = employmentStatNo;
  }



}

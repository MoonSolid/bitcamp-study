package backup.jobposting;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;;

public class JobPosting implements Serializable {
  private static final long serialVersionUID = 1L;

  private int jobPostingNumber;
  private int companyMemberNumber;
  private String title;
  private String content;
  private int workPlaceNumber;
  private int minimumCareer;
  private int viewCount;
  private Date postingRegistration;
  private Date startDated;
  private Date endDated;
  private String job;
  private String thumnail;
  private int yearSalary;
  private int readable;
  private int minimumEducationNumber;
  private int employmentStatNumber;
  List<JobPostingFile> files;


  @Override
  public String toString() {
    return "JobPosting [jobPostingNumber=" + jobPostingNumber + ", companyMemberNumber="
        + companyMemberNumber + ", title=" + title + ", content=" + content + ", workPlaceNumber="
        + workPlaceNumber + ", minimumCareer=" + minimumCareer + ", viewCount=" + viewCount
        + ", postingRegistration=" + postingRegistration + ", startDated=" + startDated
        + ", endDated=" + endDated + ", job=" + job + ", thumnail=" + thumnail + ", yearSalary="
        + yearSalary + ", readable=" + readable + ", minimumEducationNumber="
        + minimumEducationNumber + ", employmentStatNumber=" + employmentStatNumber + ", files="
        + files + "]";
  }


  public int getJobPostingNumber() {
    return jobPostingNumber;
  }

  public void setJobPostingNumber(int jobPostingNumber) {
    this.jobPostingNumber = jobPostingNumber;
  }

  public int getCompanyMemberNumber() {
    return companyMemberNumber;
  }

  public void setCompanyMemberNumber(int companyMemberNumber) {
    this.companyMemberNumber = companyMemberNumber;
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

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public Date getPostingRegistration() {
    return postingRegistration;
  }

  public void setPostingRegistration(Date postingRegistration) {
    this.postingRegistration = postingRegistration;
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


  public List<JobPostingFile> getFiles() {
    return files;
  }

  public void setFiles(List<JobPostingFile> files) {
    this.files = files;
  }



}

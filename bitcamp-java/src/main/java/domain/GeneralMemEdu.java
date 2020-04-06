package domain;

import java.io.Serializable;

public class GeneralMemEdu implements Serializable {
  private static final long serialVersionUID = 1L;

  private int generalMemberNo;
  private int educationNo;
  private String schoolName;

  @Override
  public String toString() {
    return "GeneralMemEdu [generalMemberNo=" + generalMemberNo + ", educationNo=" + educationNo
        + ", schoolName=" + schoolName + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + educationNo;
    result = prime * result + generalMemberNo;
    result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
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
    GeneralMemEdu other = (GeneralMemEdu) obj;
    if (educationNo != other.educationNo)
      return false;
    if (generalMemberNo != other.generalMemberNo)
      return false;
    if (schoolName == null) {
      if (other.schoolName != null)
        return false;
    } else if (!schoolName.equals(other.schoolName))
      return false;
    return true;
  }

  public int getGeneralMemberNo() {
    return generalMemberNo;
  }

  public void setGeneralMemberNo(int generalMemberNo) {
    this.generalMemberNo = generalMemberNo;
  }

  public int getEducationNo() {
    return educationNo;
  }

  public void setEducationNo(int educationNo) {
    this.educationNo = educationNo;
  }

  public String getSchoolName() {
    return schoolName;
  }

  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }


}

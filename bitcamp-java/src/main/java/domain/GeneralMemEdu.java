package domain;

import java.io.Serializable;

public class GeneralMemEdu implements Serializable {
  private static final long serialVersionUID = 1L;

  private int generalMemberNumber;
  private int educationNumber;
  private String schoolName;

  @Override
  public String toString() {
    return "GeneralMemEdu [generalMemberNumber=" + generalMemberNumber + ", educationNumber="
        + educationNumber + ", schoolName=" + schoolName + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + educationNumber;
    result = prime * result + generalMemberNumber;
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
    if (educationNumber != other.educationNumber)
      return false;
    if (generalMemberNumber != other.generalMemberNumber)
      return false;
    if (schoolName == null) {
      if (other.schoolName != null)
        return false;
    } else if (!schoolName.equals(other.schoolName))
      return false;
    return true;
  }

  public int getGeneralMemberNumber() {
    return generalMemberNumber;
  }

  public void setGeneralMemberNumber(int generalMemberNumber) {
    this.generalMemberNumber = generalMemberNumber;
  }

  public int getEducationNumber() {
    return educationNumber;
  }

  public void setEducationNumber(int educationNumber) {
    this.educationNumber = educationNumber;
  }

  public String getSchoolName() {
    return schoolName;
  }

  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }


}

package domain;

import java.io.Serializable;

public class GeneralMemEduMajor implements Serializable {
  private static final long serialVersionUID = 1L;


  private int generalMemberNumber;
  private int educationNumber;
  private int majorNumber;

  @Override
  public String toString() {
    return "GeneralMemEduMajor [generalMemberNumber=" + generalMemberNumber + ", educationNumber="
        + educationNumber + ", majorNumber=" + majorNumber + "]";
  }



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + educationNumber;
    result = prime * result + generalMemberNumber;
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
    GeneralMemEduMajor other = (GeneralMemEduMajor) obj;
    if (educationNumber != other.educationNumber)
      return false;
    if (generalMemberNumber != other.generalMemberNumber)
      return false;
    if (majorNumber != other.majorNumber)
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

  public int getMajorNumber() {
    return majorNumber;
  }

  public void setMajorNumber(int majorNumber) {
    this.majorNumber = majorNumber;
  }


}

package domain;

import java.io.Serializable;

public class GeneralMemEduMajor implements Serializable {
  private static final long serialVersionUID = 1L;


  private int generalMemberNo;
  private int educationNo;
  private int majorNo;

  @Override
  public String toString() {
    return "GeneralMemEduMajor [generalMemberNo=" + generalMemberNo + ", educationNo=" + educationNo
        + ", majorNo=" + majorNo + "]";
  }



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + educationNo;
    result = prime * result + generalMemberNo;
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
    GeneralMemEduMajor other = (GeneralMemEduMajor) obj;
    if (educationNo != other.educationNo)
      return false;
    if (generalMemberNo != other.generalMemberNo)
      return false;
    if (majorNo != other.majorNo)
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

  public int getMajorNo() {
    return majorNo;
  }

  public void setMajorNo(int majorNo) {
    this.majorNo = majorNo;
  }


}

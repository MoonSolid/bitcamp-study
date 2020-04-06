package domain;

import java.io.Serializable;

public class EmploymentStatus implements Serializable {

  private static final long serialVersionUID = 1L;

  private int employmentStatNo;
  private String employmentStatName;

  @Override
  public String toString() {
    return "employmentStatus [employmentStatNo=" + employmentStatNo + ", employmentStatName="
        + employmentStatName + "]";
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((employmentStatName == null) ? 0 : employmentStatName.hashCode());
    result = prime * result + employmentStatNo;
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
    EmploymentStatus other = (EmploymentStatus) obj;
    if (employmentStatName == null) {
      if (other.employmentStatName != null)
        return false;
    } else if (!employmentStatName.equals(other.employmentStatName))
      return false;
    if (employmentStatNo != other.employmentStatNo)
      return false;
    return true;
  }


  public int getEmploymentStatNo() {
    return employmentStatNo;
  }

  public void setEmploymentStatNo(int employmentStatNo) {
    this.employmentStatNo = employmentStatNo;
  }

  public String getEmploymentStatName() {
    return employmentStatName;
  }

  public void setEmploymentStatName(String employmentStatName) {
    this.employmentStatName = employmentStatName;
  }

}

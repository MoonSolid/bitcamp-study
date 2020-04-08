package domain;

import java.io.Serializable;

public class EmploymentStatus implements Serializable {

  private static final long serialVersionUID = 1L;

  private int employmentStatNumber;
  private String employmentStatName;

  @Override
  public String toString() {
    return "employmentStatus [employmentStatNumber=" + employmentStatNumber
        + ", employmentStatName=" + employmentStatName + "]";
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((employmentStatName == null) ? 0 : employmentStatName.hashCode());
    result = prime * result + employmentStatNumber;
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
    if (employmentStatNumber != other.employmentStatNumber)
      return false;
    return true;
  }


  public int getEmploymentStatNumber() {
    return employmentStatNumber;
  }

  public void setEmploymentStatNumber(int employmentStatNumber) {
    this.employmentStatNumber = employmentStatNumber;
  }

  public String getEmploymentStatName() {
    return employmentStatName;
  }

  public void setEmploymentStatName(String employmentStatName) {
    this.employmentStatName = employmentStatName;
  }

}

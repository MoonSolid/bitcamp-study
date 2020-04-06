package domain;

import java.io.Serializable;

public class Major implements Serializable {

  private static final long serialVersionUID = 1L;

  private int majorNo;
  private String name;

  @Override
  public String toString() {
    return "Major [majorNo=" + majorNo + ", name=" + name + "]";
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + majorNo;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    Major other = (Major) obj;
    if (majorNo != other.majorNo)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }


  public int getMajorNo() {
    return majorNo;
  }

  public void setMajorNo(int majorNo) {
    this.majorNo = majorNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


}

package com.revature.reimbursement.model;

public class EmployeeModel {
  
  private int eId;
  private String epass;
  private String ename;
  private String eteam;
  private String erole;
  private String eemail;
  private String eaddress;
  private String ephone;
  private boolean ismanager;
  private String eimageurl;
  
  public EmployeeModel(int eId, String epass, String ename, String eteam, String erole,
      String eemail, String eaddress, String ephone, boolean ismanager, String eimageurl) {
    super();
    this.eId = eId;
    this.epass = epass;
    this.ename = ename;
    this.eteam = eteam;
    this.erole = erole;
    this.eemail = eemail;
    this.eaddress = eaddress;
    this.ephone = ephone;
    this.ismanager = ismanager;
    this.eimageurl = eimageurl;
  }
  
  public EmployeeModel() {
    super();
  }

  public int geteId() {
    return eId;
  }

  public void seteId(int eId) {
    this.eId = eId;
  }

  public String getEpass() {
    return epass;
  }

  public void setEpass(String epass) {
    this.epass = epass;
  }

  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public String getEteam() {
    return eteam;
  }

  public void setEteam(String eteam) {
    this.eteam = eteam;
  }

  public String getErole() {
    return erole;
  }

  public void setErole(String erole) {
    this.erole = erole;
  }

  public String getEemail() {
    return eemail;
  }

  public void setEemail(String eemail) {
    this.eemail = eemail;
  }

  public String getEaddress() {
    return eaddress;
  }

  public void setEaddress(String eaddress) {
    this.eaddress = eaddress;
  }

  public String getEphone() {
    return ephone;
  }

  public void setEphone(String ephone) {
    this.ephone = ephone;
  }

  public boolean isIsmanager() {
    return ismanager;
  }

  public void setIsmanager(boolean ismanager) {
    this.ismanager = ismanager;
  }

  public String getEimageurl() {
    return eimageurl;
  }

  public void setEimageurl(String eimageurl) {
    this.eimageurl = eimageurl;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + eId;
    result = prime * result + ((eaddress == null) ? 0 : eaddress.hashCode());
    result = prime * result + ((eemail == null) ? 0 : eemail.hashCode());
    result = prime * result + ((eimageurl == null) ? 0 : eimageurl.hashCode());
    result = prime * result + ((ename == null) ? 0 : ename.hashCode());
    result = prime * result + ((epass == null) ? 0 : epass.hashCode());
    result = prime * result + ((ephone == null) ? 0 : ephone.hashCode());
    result = prime * result + ((erole == null) ? 0 : erole.hashCode());
    result = prime * result + ((eteam == null) ? 0 : eteam.hashCode());
    result = prime * result + (ismanager ? 1231 : 1237);
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
    EmployeeModel other = (EmployeeModel) obj;
    if (eId != other.eId)
      return false;
    if (eaddress == null) {
      if (other.eaddress != null)
        return false;
    } else if (!eaddress.equals(other.eaddress))
      return false;
    if (eemail == null) {
      if (other.eemail != null)
        return false;
    } else if (!eemail.equals(other.eemail))
      return false;
    if (eimageurl == null) {
      if (other.eimageurl != null)
        return false;
    } else if (!eimageurl.equals(other.eimageurl))
      return false;
    if (ename == null) {
      if (other.ename != null)
        return false;
    } else if (!ename.equals(other.ename))
      return false;
    if (epass == null) {
      if (other.epass != null)
        return false;
    } else if (!epass.equals(other.epass))
      return false;
    if (ephone == null) {
      if (other.ephone != null)
        return false;
    } else if (!ephone.equals(other.ephone))
      return false;
    if (erole == null) {
      if (other.erole != null)
        return false;
    } else if (!erole.equals(other.erole))
      return false;
    if (eteam == null) {
      if (other.eteam != null)
        return false;
    } else if (!eteam.equals(other.eteam))
      return false;
    if (ismanager != other.ismanager)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "EmployeeModel [eId=" + eId + ", epass=" + epass + ", ename=" + ename + ", eteam="
        + eteam + ", erole=" + erole + ", eemail=" + eemail + ", eaddress=" + eaddress + ", ephone="
        + ephone + ", ismanager=" + ismanager + ", eimageurl=" + eimageurl + "]";
  }
  
  
  
  
  

}

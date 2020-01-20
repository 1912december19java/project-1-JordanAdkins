package com.revature.reimbursement.model;

public class EmployeeNameModel {
  
  private String name;
  
  public EmployeeNameModel() {
    super();
  }
  public EmployeeNameModel(String name) {
    this.setName(name);
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

}

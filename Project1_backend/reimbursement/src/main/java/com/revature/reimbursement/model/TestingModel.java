package com.revature.reimbursement.model;

public class TestingModel {
  
  private String employeeId;
  private String password;
  
  public TestingModel(){
    super();
  }
  
  public TestingModel(String employeeId, String Password){
	  this.employeeId = employeeId;
	  this.password = Password;
  }

public String getemployeeId() {
	return employeeId;
}

public void setemployeeId(String employeeId) {
	this.employeeId = employeeId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "TestingModel [employeeId=" + employeeId + ", password=" + password + "]";
}
  
  
}

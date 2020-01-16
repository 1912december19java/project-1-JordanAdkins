package com.revature.reimbursement.model;

public class TestingModel {
  
  private String name;
  private String password;
  
  public TestingModel(){
    super();
  }
  
  public TestingModel(String name, String Password){
	  this.name = name;
	  this.password = Password;
  }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "TestingModel [name=" + name + ", password=" + password + "]";
}
  
  
}

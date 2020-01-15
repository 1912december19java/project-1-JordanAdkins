package com.revature.reimbursement.model;

public class TestingModel {
  
  private String name;
  private String password;
  
  public TestingModel(){
    super();
  }
  
  public TestingModel(String name, String Password){
    super();
  }
  
  @Override
  public String toString() {
    String newString = (name + " " + password);
    return newString;
  }
}

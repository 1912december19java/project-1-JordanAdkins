package com.revature.reimbursement.model;

public class LoginModel {

  private String id = null;
  private String password = null;

  public LoginModel() {
    super();
  }

  public LoginModel(String id, String password) {
    super();
    this.id = id;
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "LoginModel [id=" + id + ", password=" + password + "]";
  }

}

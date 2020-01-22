package com.revature.reimbursement.model;

public class ApprovalModel {
  
  public ApprovalModel() {
    super();
  }
  
  public ApprovalModel(String name, int req) {
    super();
    Name = name;
    this.req = req;
  }
  public String getName() {
    return Name;
  }
  public void setName(String name) {
    Name = name;
  }
  public int getReq() {
    return req;
  }
  public void setReq(int req) {
    this.req = req;
  }
  private String Name;
  private int req;

}

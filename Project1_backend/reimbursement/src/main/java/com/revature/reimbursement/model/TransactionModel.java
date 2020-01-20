package com.revature.reimbursement.model;

public class TransactionModel {
  
  private int reqid;
  private int empid;
  private String date;
  private String amount;
  private boolean preapproval;
  private boolean pending;
  private boolean approved; 
  private String rurl;
  private String approvedBy;
  private String ename;
  private String team;
  
  public TransactionModel() {
    super();
  }

  public TransactionModel(int reqid, int empid, String date, String amount, boolean preapproval,
      boolean pending, boolean approved, String rurl, String approvedBy, String ename, String team) {
    super();
    this.reqid = reqid;
    this.empid = empid;
    this.date = date;
    this.amount = amount;
    this.preapproval = preapproval;
    this.pending = pending;
    this.approved = approved;
    this.rurl = rurl;
    this.setApprovedBy(approvedBy);
    this.ename = ename;
    this.team = team;
  }

  public int getReqid() {
    return reqid;
  }

  @Override
  public String toString() {
    return "TransactionModel [reqid=" + reqid + ", empid=" + empid + ", date=" + date + ", amount="
        + amount + ", preapproval=" + preapproval + ", pending=" + pending + ", approved="
        + approved + ", rurl=" + rurl + ", approvedBy=" + approvedBy + ", name=" + ename +"]";
  }

  public void setReqid(int reqid) {
    this.reqid = reqid;
  }

  public int getEmpid() {
    return empid;
  }

  public void setEmpid(int empid) {
    this.empid = empid;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public boolean isPreapproval() {
    return preapproval;
  }

  public void setPreapproval(boolean preapproval) {
    this.preapproval = preapproval;
  }

  public boolean isPending() {
    return pending;
  }

  public void setPending(boolean pending) {
    this.pending = pending;
  }

  public boolean isApproved() {
    return approved;
  }

  public void setApproved(boolean approved) {
    this.approved = approved;
  }

  public String getRurl() {
    return rurl;
  }

  public void setRurl(String rurl) {
    this.rurl = rurl;
  }

  public String getApprovedBy() {
    return approvedBy;
  }

  public void setApprovedBy(String approvedBy) {
    this.approvedBy = approvedBy;
  }

  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }
  
  

}

package com.revature.reimbursement.model;

public class EmployeeListModel {
  
  private String name;
  private String team;
  private String ProfileUrl;
  @Override
  public String toString() {
    return "EmployeeListModel [name=" + name + ", team=" + team + ", ProfileUrl=" + ProfileUrl
        + ", role=" + role + "]";
  }

  private String role;
  
  public EmployeeListModel() {
    super();
  }
  
  public EmployeeListModel(String name, String team, String role, String profileUrl) {
    super();
    this.name = name;
    this.team = team;
    this.ProfileUrl = profileUrl;
    this.role = role;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getTeam() {
    return team;
  }
  public void setTeam(String team) {
    this.team = team;
  }
  public String getProfileUrl() {
    return ProfileUrl;
  }
  public void setProfileUrl(String profileUrl) {
    ProfileUrl = profileUrl;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

}

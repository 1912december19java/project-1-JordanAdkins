package com.revature.reimbursement.repository;

import java.util.List;
import com.revature.reimbursement.model.EmployeeListModel;

public interface EmployeeDao {
  
  
  /**
   * Checks for id
   */
  public int checkForId(int id);
  
  /**
   * Checks for password
   */
  public String checkForPassword(int id);
  
  /**
   * Checks for name
   */
  public String checkForName(int id);
  
  /**
   * Checks for team
   */
  public String checkForTeam(int id);
  
  /**
   * Checks for role
   */
  public String checkForRole(int id);
  
  /**
   * Checks for email
   */
  public String checkForEmail(int id);
  
  /**
   * Checks for address
   */
  public String checkForAddress(int id);
  
  /**
   * Checks for phone
   */
  public String checkForPhone(int id);
  
  /**
   * Checks if manager
   */
  public boolean checkifManager(int id);
  
  /**
   * Checks for profile picture
   */
  
  public String checkForProfilePicUrl(int id);
  
  /**
   * Creates a list of all employees
   */
  public List<EmployeeListModel> getEmployeeList();
  
}

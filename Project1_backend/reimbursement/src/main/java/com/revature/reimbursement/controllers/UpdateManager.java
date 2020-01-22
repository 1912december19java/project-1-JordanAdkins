package com.revature.reimbursement.controllers;

import com.revature.reimbursement.repository.EmployeeDaoPostgres;

public class UpdateManager {
  
  public static boolean updateUser(String name, String email, String address, String phone, int id) {
    EmployeeDaoPostgres employeeDao = new EmployeeDaoPostgres();
    
    if(employeeDao.updateInformation(name, email, address, phone, id)) {
      return true;
    }
    return false;
  }

}

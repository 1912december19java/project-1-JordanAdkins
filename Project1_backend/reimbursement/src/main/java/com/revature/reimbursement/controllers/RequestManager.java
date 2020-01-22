package com.revature.reimbursement.controllers;

import org.apache.log4j.Logger;
import com.revature.reimbursement.repository.EmployeeDaoPostgres;

public class RequestManager {
  
  public static Logger log = Logger.getLogger(LoginManager.class);
  
  public static boolean insertNewRequest(int eid, String date, String amount, boolean preapproval,
      String url) {  
    EmployeeDaoPostgres employeeDao = new EmployeeDaoPostgres();
    
    if(employeeDao.saveNewRequest(eid, date, amount, preapproval, url)) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public static boolean approveRequest(String name, int reqId) {
    EmployeeDaoPostgres employeeDao = new EmployeeDaoPostgres();
    if(employeeDao.approveRequest(name, reqId)) {
      return true;
    } else {
     return false; 
    }
  }
  
  public static boolean denyRequest(int reqId) {
    EmployeeDaoPostgres employeeDao = new EmployeeDaoPostgres();
    if(employeeDao.denyRequest(reqId)) {
      return true;
    } else {
     return false; 
    }
  }
}

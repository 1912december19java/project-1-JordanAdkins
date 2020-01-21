package com.revature.reimbursement.controllers;

import org.apache.log4j.Logger;
import com.revature.reimbursement.repository.EmployeeDaoPostgres;

public class LoginManager {
  
  public static Logger log = Logger.getLogger(LoginManager.class);
  
  EmployeeDaoPostgres loginDao;
  
  public LoginManager(EmployeeDaoPostgres loginDaoPostgres) {
    this.loginDao = loginDaoPostgres;
  }
  

  public boolean isValidLoginCombo(String id, String password) {
    int idAsInt = Integer.parseInt(id);
    log.trace("id parsed as int");
    int validateId = loginDao.checkForId(idAsInt);
    if(validateId == 0) {
      return false;
    }
    if(password.equals(loginDao.checkForPassword(validateId))) {
      log.debug("password matched");
      return true;
    }
    log.debug("passwords do NOT match");
    return false;
  }

}

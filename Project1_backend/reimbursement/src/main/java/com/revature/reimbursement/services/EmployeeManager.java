package com.revature.reimbursement.services;

import org.apache.log4j.Logger;
import com.revature.reimbursement.model.EmployeeModel;
import com.revature.reimbursement.repository.EmployeeDaoPostgres;

public class EmployeeManager {
  
 public static Logger log = Logger.getLogger(LoginManager.class);
  
  EmployeeDaoPostgres employeeDao;
  
  public EmployeeManager(EmployeeDaoPostgres EmployeeDaoPostgres) {
    this.employeeDao = EmployeeDaoPostgres;
  }
  
  public EmployeeModel buildEmployee(int id){
    EmployeeModel returnModel = new EmployeeModel(
        employeeDao.checkForId(id),
        employeeDao.checkForPassword(id),
        employeeDao.checkForName(id),
        employeeDao.checkForTeam(id),
        employeeDao.checkForRole(id),
        employeeDao.checkForEmail(id),
        employeeDao.checkForAddress(id),
        employeeDao.checkForPhone(id),
        employeeDao.checkifManager(id),
        employeeDao.checkForProfilePicUrl(id)
        );
    return returnModel;
  }

}

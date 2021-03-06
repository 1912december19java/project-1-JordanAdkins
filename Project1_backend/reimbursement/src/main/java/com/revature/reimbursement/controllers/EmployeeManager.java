package com.revature.reimbursement.controllers;

import java.util.List;
import org.apache.log4j.Logger;
import com.revature.reimbursement.model.EmployeeListModel;
import com.revature.reimbursement.model.EmployeeModel;
import com.revature.reimbursement.model.TransactionModel;
import com.revature.reimbursement.repository.EmployeeDaoPostgres;

public class EmployeeManager {
  
 public static Logger log = Logger.getLogger(LoginManager.class);
  
  EmployeeDaoPostgres employeeDao;
  
  public EmployeeManager(EmployeeDaoPostgres EmployeeDaoPostgres) {
    this.employeeDao = EmployeeDaoPostgres;
  }
  
  public String getName(int id) {
    return employeeDao.checkForName(id);
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
  
  public List<EmployeeListModel> getAllEmployees(){
    return employeeDao.getEmployeeList();
  }
  
  public List<TransactionModel> getAllTransactions(){
    return employeeDao.getTransactions();
  }

}

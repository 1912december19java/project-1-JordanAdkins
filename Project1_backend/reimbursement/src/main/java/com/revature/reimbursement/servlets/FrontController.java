package com.revature.reimbursement.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.controllers.EmployeeManager;
import com.revature.reimbursement.controllers.LoginManager;
import com.revature.reimbursement.controllers.RequestManager;
import com.revature.reimbursement.model.ApprovalModel;
import com.revature.reimbursement.model.AuthenticationModel;
import com.revature.reimbursement.model.EmployeeListModel;
import com.revature.reimbursement.model.EmployeeModel;
import com.revature.reimbursement.model.LoginModel;
import com.revature.reimbursement.model.TransactionModel;
import com.revature.reimbursement.repository.EmployeeDaoPostgres;
import com.revature.reimbursement.services.BetterParseBoolean;
import com.revature.reimbursement.services.InputStreamTranslator;
import com.revature.reimbursement.services.StorePicture;

@WebServlet(name = "FrontController", urlPatterns = {"/*"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10, // 10 MB
maxRequestSize = 1024 * 1024 * 15, // 15 MB
location = "/")
public class FrontController extends HttpServlet {

  private static final long serialVersionUID = 3173399440215144549L;
  public static Logger log = Logger.getLogger(FrontController.class);
  private ObjectMapper om = new ObjectMapper();
  private LoginManager loginManager;
  private EmployeeManager employeeManager;

  @Override
  public void init() throws ServletException {
    this.loginManager = new LoginManager(new EmployeeDaoPostgres());
    this.employeeManager = new EmployeeManager(new EmployeeDaoPostgres());
    this.om = new ObjectMapper();
    super.init();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.trace("doGet Reached");
    String reqUri = req.getRequestURI();
    String[] uriComponents = reqUri.split("/");
    switch (uriComponents[(uriComponents.length - 1)]) {
      case "employeelist":
        log.debug("employeeList Reached");
        List<EmployeeListModel> returnEmployeeList = employeeManager.getAllEmployees();
        resp.getWriter().write(om.writeValueAsString(returnEmployeeList));
        resp.getWriter().flush();
        break;
      case "trans":
        log.debug("transaction table reached");
        List<TransactionModel> returnTransactionList = employeeManager.getAllTransactions();
        resp.getWriter().write(om.writeValueAsString(returnTransactionList));
        resp.getWriter().flush();
        break;
        default:
          resp.sendError(404);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.trace("doPost Reached");
    String reqUri = req.getRequestURI();
    String[] uriComponents = reqUri.split("/");
    switch (uriComponents[(uriComponents.length - 1)]) {
      case "login":
        log.debug("attemping login");
        LoginModel user = om.readValue(req.getReader(), LoginModel.class);
        if (loginManager.isValidLoginCombo(user.getId(), user.getPassword())) {
          user.setPassword("");
          resp.getWriter().write(om.writeValueAsString(user));
          resp.getWriter().flush();
        } else {
          resp.getWriter().write("Incorrect Info");
          resp.getWriter().flush();
        }
        break;
      case "employeeinfo":
        log.debug("reached POST employeeinfo");
        AuthenticationModel auth = om.readValue(req.getReader(), AuthenticationModel.class);
        int currentUserId = (auth.getId() / 6363);
        EmployeeModel currentUser = employeeManager.buildEmployee(currentUserId);
        resp.getWriter().write(om.writeValueAsString(currentUser));
        resp.getWriter().flush();
        break;
      case "upload":
        log.debug("reached POST upload");
        Part image = req.getPart("upload");
        Part preapproval = req.getPart("pre-approved");
        Part amount = req.getPart("amount");
        Part date = req.getPart("date");
        //Part name = req.getPart("name");
        Part eid = req.getPart("eid");
        log.debug("successfully broke into parts");
        String preapprovalString = InputStreamTranslator.inputStreamToString(preapproval.getInputStream());
        String amountString = InputStreamTranslator.inputStreamToString(amount.getInputStream());
        String dateString = InputStreamTranslator.inputStreamToString(date.getInputStream());
        String eidString = InputStreamTranslator.inputStreamToString(eid.getInputStream());
        try {
          boolean preapprovalBool = BetterParseBoolean.doIt(preapprovalString);
          int eidInt = Integer.parseInt(eidString);
          eidInt = (eidInt / 6363);
          String uploadUrl = StorePicture.uploadToS3(image);
          if(RequestManager.insertNewRequest(eidInt, dateString, amountString, preapprovalBool, uploadUrl)) {
            System.out.println("Stored Successfully");
          }
          else {
            System.out.println("Failed to Store");
          }
        }catch(Exception e) {
          System.out.println("Parsing Error");
        }       
        break;
      case "approve":
        System.out.println("reached approval");
        ApprovalModel approve = om.readValue(req.getReader(), ApprovalModel.class);
        if(RequestManager.approveRequest(approve.getName(), approve.getReq())) {
          System.out.println("request Successful!");
        };
        break;
      case "deny":
        System.out.println("Reached Deny");
        ApprovalModel deny = om.readValue(req.getReader(), ApprovalModel.class);
        if(RequestManager.denyRequest(deny.getReq())) {
          System.out.println("Deny Successful!");
        };
        break;
        
      default: { 
        log.debug("Bad request returning 400");
        if (!resp.isCommitted()) {
          resp.sendError(400);
        }
      }
    }
  }
}
package com.revature.reimbursement.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.log4j.Logger;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursement.model.EmployeeModel;
import com.revature.reimbursement.model.LoginModel;
import com.revature.reimbursement.model.WebsiteInfo;
import com.revature.reimbursement.repository.EmployeeDaoPostgres;
import com.revature.reimbursement.services.EmployeeManager;
import com.revature.reimbursement.services.LoginManager;

@WebServlet(name = "FrontController", urlPatterns = {"/*"})
public class FrontController extends HttpServlet {

  public static Logger log = Logger.getLogger(FrontController.class);
  private static ObjectMapper om = new ObjectMapper();
  private LoginManager loginManager;
  private EmployeeManager employeeManager;

  @Override
  public void init() throws ServletException {
    this.loginManager = new LoginManager(new EmployeeDaoPostgres());
    this.employeeManager = new EmployeeManager(new EmployeeDaoPostgres());
    this.om = new ObjectMapper();
    WebsiteInfo initinfo = new WebsiteInfo();
    super.init();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.trace("doGet Reached");
    boolean validUser = false;
    int currentUserId = 0;
    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("vchk")) {
          validUser = true;
        } else if (cookie.getName().equals("reqn")) {
          currentUserId = Integer.parseInt(cookie.getValue());
        }
      }
    }
    if (validUser == false || currentUserId == 0) {
      log.debug("request does not have valid cookies redirecting");
      resp.sendRedirect(WebsiteInfo.indexUrl);
    }
    String reqUri = req.getRequestURI();
    String[] uriComponents = reqUri.split("/");
    switch (uriComponents[(uriComponents.length - 1)]) {
      case "employeeinfo":
        EmployeeModel currentUser = employeeManager.buildEmployee(currentUserId);
        resp.getWriter().write(currentUser.toString());
        break;
      default: {
        log.debug("Bad request returning 400");
        if (!resp.isCommitted()) {
          resp.sendError(400);
        }
      }
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
          Cookie idCookie = new Cookie("reqn", user.getId());
          Cookie validCheckCookie = new Cookie("vchk", "eissamyar");
          log.debug("adding cookies");
          resp.addCookie(idCookie);
          resp.addCookie(validCheckCookie);
          user.setPassword("");
          resp.getWriter().write(om.writeValueAsString(user));
        } else {
          resp.getWriter().write("Incorrect Info");
          resp.getWriter().flush();
        }
        break;
      case "2":
        System.out.println("world");
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
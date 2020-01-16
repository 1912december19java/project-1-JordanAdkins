package com.revature.reimbursement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.reimbursement.model.TestingModel;

@WebServlet(name = "FrontController", urlPatterns = {"/*"})
public class FrontController extends HttpServlet {
  
  private ObjectMapper om;
  
  @Override
  public void init() throws ServletException {
    super.init();
    this.om = new ObjectMapper();
    om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("DoGet Reached");
    System.out.println("URI" + req.getRequestURI());
    
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
   System.out.println("Post received");
   TestingModel test = om.readValue(req.getReader(), TestingModel.class);
   System.out.println(test);
   
   resp.getWriter().write(om.writeValueAsString(test));
  }

}

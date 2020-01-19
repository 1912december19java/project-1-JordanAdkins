package com.revature.reimbursement.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class DbUtil {
  private static Logger log = Logger.getLogger(DbUtil.class);

  public static void safeClose(Connection conn){
    
      try {
        conn.close();
      } catch (SQLException e) {
        log.error("failed to close connection");
        e.printStackTrace();
      }
  }
  
  public static void safeClose(Statement stmt){
    
    try {
      stmt.close();
    } catch (SQLException e) {
      log.error("failed to close connection");
      e.printStackTrace();
    }
}
  
  public static void safeClose(ResultSet rs){
    
    try {
      rs.close();
    } catch (SQLException e) {
      log.error("failed to close connection");
      e.printStackTrace();
    }
}

}

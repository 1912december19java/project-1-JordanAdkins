package com.revature.reimbursement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.log4j.Logger;

public class EmployeeDaoPostgres implements EmployeeDao {

  private static Logger log = Logger.getLogger(EmployeeDaoPostgres.class);

  /**
   * Finds the connection driver, and connects to database.
   */
  static {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    }
  }

  @Override
  public int checkForId(int id) {
    Connection conn;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      PreparedStatement stmt;
      stmt = conn.prepareStatement("SELECT employee_id FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      ResultSet rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("id is valid");
        return rs.getInt(1);
      } else {
        log.trace("id is NOT valid");
        return 0;
      }
    } catch (SQLException e) {
      log.error("Failed to get from database");
      e.printStackTrace();
      return 0;
    }
  }

  @Override
  public String checkForPassword(int id) {
    Connection conn;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      PreparedStatement stmt;
      stmt =
          conn.prepareStatement("SELECT employee_pass FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      ResultSet rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("pass is valid");
        return rs.getString(1);
      } else {
        log.trace("pass is NOT valid");
        return null;
      }
    } catch (SQLException e) {
      log.error("Failed to get from database");
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String checkForName(int id) {
    Connection conn;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      PreparedStatement stmt;
      stmt =
          conn.prepareStatement("SELECT employee_name FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      ResultSet rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("name is valid");
        return rs.getString(1);
      } else {
        log.trace("name is NOT valid");
        return null;
      }
    } catch (SQLException e) {
      log.error("Failed to get from database");
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String checkForTeam(int id) {
    Connection conn;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      PreparedStatement stmt;
      stmt =
          conn.prepareStatement("SELECT employee_team FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      ResultSet rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("team is valid");
        return rs.getString(1);
      } else {
        log.trace("tam is NOT valid");
        return null;
      }
    } catch (SQLException e) {
      log.error("Failed to get from database");
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String checkForRole(int id) {
    Connection conn;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      PreparedStatement stmt;
      stmt =
          conn.prepareStatement("SELECT employee_role FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      ResultSet rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("role is valid");
        return rs.getString(1);
      } else {
        log.trace("role is NOT valid");
        return null;
      }
    } catch (SQLException e) {
      log.error("Failed to get from database");
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String checkForEmail(int id) {
    PreparedStatement stmt;
    Connection conn;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      stmt =
          conn.prepareStatement("SELECT employee_email FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      ResultSet rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("email is valid");
        return rs.getString(1);
      } else {
        log.trace("email is NOT valid");
        return null;
      }
    } catch (SQLException e) {
      log.error("Failed to get from database");
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String checkForAddress(int id) {
    Connection conn;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      PreparedStatement stmt;
      stmt = conn
          .prepareStatement("SELECT employee_address FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      ResultSet rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("address is valid");
        return rs.getString(1);
      } else {
        log.trace("address is NOT valid");
        return null;
      }
    } catch (SQLException e) {
      log.error("Failed to get from database");
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String checkForPhone(int id) {
    Connection conn;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      PreparedStatement stmt;
      stmt =
          conn.prepareStatement("SELECT employee_phone FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      ResultSet rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("phone is valid");
        return rs.getString(1);
      } else {
        log.trace("phone is NOT valid");
        return null;
      }
    } catch (SQLException e) {
      log.error("Failed to get from database");
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public boolean checkifManager(int id) {
    Connection conn;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      PreparedStatement stmt;
      stmt = conn
          .prepareStatement("SELECT employee_ismanager FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      ResultSet rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("ismanager is valid");
        return rs.getBoolean(1);
      } else {
        log.trace("ismanager is NOT valid");
        return false;
      }
    } catch (SQLException e) {
      log.error("Failed to get from database");
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public String checkForProfilePicUrl(int id) {
    Connection conn;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      PreparedStatement stmt;
      stmt = conn
          .prepareStatement("SELECT employee_image_url FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      ResultSet rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("url is valid");
        return rs.getString(1);
      } else {
        log.trace("url is NOT valid");
        return null;
      }
    } catch (SQLException e) {
      log.error("Failed to get from database");
      e.printStackTrace();
      return null;
    }
  }


  @Override
  public List<Integer> getAllEmployees() {
    // TODO Auto-generated method stub
    return null;
  }



}

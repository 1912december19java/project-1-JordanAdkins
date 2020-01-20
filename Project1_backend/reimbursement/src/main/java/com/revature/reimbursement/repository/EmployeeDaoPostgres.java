package com.revature.reimbursement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.revature.reimbursement.model.EmployeeListModel;

public class EmployeeDaoPostgres implements EmployeeDao {

  private static Logger log = Logger.getLogger(EmployeeDaoPostgres.class);

  /**
   * Finds the connection driver
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
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      stmt = conn.prepareStatement("SELECT employee_id FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("id is valid");
        int returnvalue = rs.getInt(1);
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
        return returnvalue;
      } else {
        log.trace("id is NOT valid");
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
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
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      stmt =
          conn.prepareStatement("SELECT employee_pass FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("pass is valid");
        String returnvalue = rs.getString(1);
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
        return returnvalue;
      } else {
        log.trace("pass is NOT valid");
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
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
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      stmt =
          conn.prepareStatement("SELECT employee_name FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("name is valid");
        String returnvalue = rs.getString(1);
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
        return returnvalue;
      } else {
        log.trace("name is NOT valid");
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
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
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      stmt =
          conn.prepareStatement("SELECT employee_team FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("team is valid");
        String returnvalue = rs.getString(1);
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
        return returnvalue;
      } else {
        log.trace("team is NOT valid");
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
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
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      stmt =
          conn.prepareStatement("SELECT employee_role FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("role is valid");
        String returnvalue = rs.getString(1);
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
        return returnvalue;
      } else {
        log.trace("role is NOT valid");
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
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
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      stmt =
          conn.prepareStatement("SELECT employee_email FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("email is valid");
        String returnvalue = rs.getString(1);
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
        return returnvalue;
      } else {
        log.trace("email is NOT valid");
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
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
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      stmt = conn
          .prepareStatement("SELECT employee_address FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("address is valid");
        String returnvalue = rs.getString(1);
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
        return returnvalue;
      } else {
        log.trace("address is NOT valid");
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
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
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      stmt =
          conn.prepareStatement("SELECT employee_phone FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("phone is valid");
        String returnvalue = rs.getString(1);
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
        return returnvalue;
      } else {
        log.trace("phone is NOT valid");
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
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
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      stmt = conn
          .prepareStatement("SELECT employee_ismanager FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("ismanager is valid");
        boolean returnvalue = rs.getBoolean(1);
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
        return returnvalue;
      } else {
        log.trace("ismanager is NOT valid");
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
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
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      stmt = conn
          .prepareStatement("SELECT employee_image_url FROM employee_info WHERE employee_id = ?;");
      stmt.setInt(1, id);
      stmt.execute();
      rs = stmt.getResultSet();
      if (rs.next()) {
        log.trace("url is valid");
        String returnvalue = rs.getString(1);
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
        return returnvalue;
      } else {
        log.trace("url is NOT valid");
        DbUtil.safeClose(rs);
        DbUtil.safeClose(stmt);
        DbUtil.safeClose(conn);
        return null;
      }
    } catch (SQLException e) {
      log.error("Failed to get from database");
      e.printStackTrace();
      return null;
    }
  }


  @Override
  public List<EmployeeListModel> getEmployeeList() {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stmt = null;
    List<EmployeeListModel> returnList = new ArrayList<EmployeeListModel>();
    try {
      conn = DriverManager.getConnection(System.getenv("connstring"),
          System.getenv("username"), System.getenv("password"));
      log.debug("Connected to Database");
      stmt = conn.prepareStatement(
          "SELECT employee_name, employee_team, employee_role, employee_image_url FROM employee_info;");
      stmt.execute();
      rs = stmt.getResultSet();
      while (rs.next()) {
        log.trace("Inserting new Employee");
        EmployeeListModel employee = new EmployeeListModel(rs.getString(1), rs.getString(2),
            rs.getString(3), rs.getString(4));
        returnList.add(employee);
        log.trace("Added: " + employee);
      }
      DbUtil.safeClose(rs);
      DbUtil.safeClose(stmt);
      DbUtil.safeClose(conn);
      return returnList;
    } catch (SQLException e) {
      log.error("Failed to get from database");
      e.printStackTrace();
      return null;
    }
  }
}



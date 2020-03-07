package JDBC;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkingWithTransactions {

  private static final Integer NO_TIMEOUT = 0;

  public static void main(String[] args) {

  }

  // attention! after invoking this method, connection will be stay in memory because we need it for tests
//  @Before
//  public void setUp() throws SQLException {
//
//    Connection connection = getConnection();
//    createTables(connection);
////    fillTables(connection);
//  }

  @Test
  public void NoOneTransaction() {
    Connection conn = null;

    try{
      conn = getConnection();
      Statement statement = conn.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from bids");
      while(resultSet.next()) {
        System.out.println(resultSet.getString("user"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    finally {
      if(conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  public void WithOneTransaction() {
    Connection conn1 = null;
    Connection conn2 = null;

    try {
      conn1 = getConnection();
      conn1.setAutoCommit(false);
//      createTables(conn1);
//      fillTables(conn1);
//      conn1.commit();

      // this is the ONLY way you start a transaction in Java with plain JDBC
//      conn.setAutoCommit(false);
//
//      Statement statement = conn.createStatement();
//      Statement statement1 = conn.createStatement();
//
//      statement.execute("insert into items(name) values('Windows 10 PremEdit')");
////      conn.commit();
//      statement.execute("insert into bids(user, time, amount, currency) values('Han Solo', now(), 1, 'UER')");
//      statement.execute("insert into bids(user, time, amount, currency) values('Frank Sinatra', now(), 2, 'UER')");
//
//      conn.rollback();
//      conn.rollback();
//      System.out.println("commit done");
//

      Statement statement1 = conn1.createStatement();
      statement1.execute("UPDATE bids SET AMOUNT = 100 WHERE id = 3;");
//      conn1.close();

//      ResultSet resultSet = statement1.executeQuery("select * from bids");
//
//      while(resultSet.next()) {
//        System.out.println(resultSet.getString("user"));
//      }


      conn2 = getConnection();
      conn2.setAutoCommit(false);
      Statement statement2 = conn2.createStatement();
      statement2.execute("UPDATE bids SET AMOUNT = 200 WHERE id = 3;");
      ResultSet resultSet2 = statement2.executeQuery("select * from bids");

      while(resultSet2.next()) {
        System.out.println(resultSet2.getString("user"));
      }

    } catch (SQLException e) {
      System.out.println(e.getSQLState());
      e.printStackTrace();
    }
//    finally {
//      if(conn1 != null) {
//        try {
//          conn1.close();
//        } catch (SQLException e) {
//          e.printStackTrace();
//        }
//      }
//    }
  }

  private void fillTables(Connection conn) throws SQLException {
    Statement statement = conn.createStatement();
    statement.execute("insert into items(name) values('Windows 10 PremEdit')");
    statement.execute("insert into bids(user, time, amount, currency) values('Han Solo', now(), 1, 'UER')");
    statement.execute("insert into bids(user, time, amount, currency) values('Frank Sinatra', now(), 2, 'UER')");
    System.out.println("tables are filled");
  }
  private Connection getConnection() throws SQLException {
//    return DriverManager.getConnection("jdbc:h2:mem:test");
    return DriverManager.getConnection("jdbc:h2:D:\\IdeaProjects\\Study\\src\\main\\trans", null, null);
  }
  private void createTables(Connection conn) {
    try {
      conn.createStatement().execute("create table items (id identity, name VARCHAR) ");
      conn.createStatement().execute("create table bids("
          + "id identity, "
          + "user VARCHAR, "
          + "time TIMESTAMP,"
          + "amount NUMBER,"
          + "currency VARCHAR)");
      conn.createStatement().execute("create table winning_bids(bid_id number, item_id number)");
      System.out.println("tables are created");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}

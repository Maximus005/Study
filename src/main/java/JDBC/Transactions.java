package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//why doesnotwork ? question below
public class Transactions {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    Class.forName("org.h2.Driver");

    Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
    Statement statement = connection.createStatement();

      statement.execute("create table user(id integer primary key auto_increment, name varchar(100));");
      statement.execute("insert into user(name) values('borya'),('petya'),('max')");

      PreparedStatement preparedStatement
          = connection.prepareStatement("insert into user(id, name) values(?,?)");

      preparedStatement.setInt(1, 4);
      preparedStatement.setString(2, "Luck");
      preparedStatement.execute();


    try(Connection connection1 = DriverManager.getConnection("jdbc:h2:mem:test");
        Statement statement1 = connection1.createStatement()) {
      connection1.setAutoCommit(false);

      statement.execute("insert into user(name) values('agent777')");
      // rollback does notwork, why ?
      connection1.rollback();
      connection1.commit();

      ResultSet rs = statement1.executeQuery("select * from user");

      while(rs.next()) {
        System.out.println(rs.getString("id") + " " + rs.getString("name"));
      }
    }
  }

}

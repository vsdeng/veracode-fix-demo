import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;

public class SQLVulnerabilitiy {
  public static void main(String[] args) throws Exception {
    Class.forName("com.mysql.jdbc.Driver").newInstance();

    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/verademo", "root", "root");
    Scanner scanner = new Scanner(System.in);
    Statement stmt = conn.createStatement();
    stmt.executeUpdate("INSERT INTO table (name) VALUES ('" + scanner.nextLine() + "');");
    stmt.close();
    
    conn.close();
  }
}
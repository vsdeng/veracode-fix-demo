import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class SQLVulnerabilitiy {
  public static void main(String[] args) throws Exception {
    Class.forName("com.mysql.jdbc.Driver").newInstance();

    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/verademo", "root", "root");
    Scanner scanner = new Scanner(System.in);
    PreparedStatement stmt = conn.prepareStatement("INSERT INTO table (name) VALUES (?);");
    stmt.setString(1, scanner.nextLine());

    stmt.executeUpdate();
    stmt.close();
    
    conn.close();
  }
}
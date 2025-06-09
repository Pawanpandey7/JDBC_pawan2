
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
         //load driver
       try{
           // Class.forName("com.mysql.jdbc.Driver");

           //establish connection
           String url ="jdbc:mysql://localhost:3307/test";
           String username = "root";
           String password = "";
           Connection conn = DriverManager.getConnection(url,username,password);

           //make statement
           Statement st = conn.createStatement();


           //execute statement
           ResultSet rs = st.executeQuery("SELECT name FROM student WHERE district='kathmandu'");
           while(rs.next()){
               String name = rs.getString("name");
               System.out.println("Name: "+name);
           }
           st.close();
           conn.close();

       } catch(SQLException sqlExcept){
           System.out.println("Error:"+sqlExcept.getMessage());
       }





    }
}
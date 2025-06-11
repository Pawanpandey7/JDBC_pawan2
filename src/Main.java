
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //load the driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ce)
        {
            System.out.print(ce.getMessage());
        }
        //create the connection
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","");
            Statement st = con.createStatement();
            String query = "SELECT * FROM student";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String name = rs.getString("name");
                String district = rs.getString("district");
                System.out.println("name: "+ name + " district: "+ district);
            }
        }catch(SQLException ex)
        {
            System.out.print(ex.getMessage());
        }
    }
}
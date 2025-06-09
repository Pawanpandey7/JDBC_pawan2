import javax.sql.rowset.*;
import java.sql.*;
public class RowSetDemo {
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3307/test";
        String username = "root";
        String password = "";
        try{
          //  Class.forName("com.mysql.jdbc.Driver");
            //first, create a factory object for rowset
            RowSetFactory rowSetFactory = RowSetProvider.newFactory();

            //create a JDBC rowset from the factory
            JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();

            //set connection properties
            rowSet.setUrl(url);
            rowSet.setUsername(username);
            rowSet.setPassword(password);

            //SetSQL query to execute
            rowSet.setCommand("SELECT * FROM student");
            rowSet.execute();
            System.out.println("id \tName \tDistrict \tAge");

            //Iterating over RowSet
            while(rowSet.next()){
                System.out.println(rowSet.getInt("id")+"\t" +
                        rowSet.getString("name")+"\t" +
                        rowSet.getString("district")+"\t"+
                        rowSet.getInt("age")+"\t");

            }
        }catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
}

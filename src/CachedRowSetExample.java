import java.sql.*;
import javax.sql.rowset.*;

public class CachedRowSetExample {
    public static void main(String[] args)
    {
        try{
            //load the driver
            //Class.forName("com.mysql.jdbc.Driver");

            //establish a connection to the database
            String url = "jdbc:mysql://localhost:3307/test";
            String username = "root";
            String password = "";
            RowSetFactory sf = RowSetProvider.newFactory();
            CachedRowSet rowset = sf.createCachedRowSet();

            rowset.setUrl(url);
            rowset.setUsername(username);
            rowset.setPassword(password);

            rowset.setCommand("SELECT * FROM STUDENT");
            rowset.execute();

            // the following code iterates all rows in the row set and print details of each row:
            while(rowset.next()){
                String name = rowset.getString("name");
                String district = rowset.getString("district");
                String age = String.valueOf(rowset.getString("age"));

                System.out.printf("%s- %s- %s\n",name,district,age);

            }
        }catch(SQLException excep){
            System.out.print(excep.getMessage());
        }




    }
}

import java.sql.*;

public class MultipleResultsExample {
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3307/test";
        String username = "root";
        String password = "";
        try{
            Class.forName("com.mysql.cj.Driver");

        }catch(ClassNotFoundException ex){
            System.out.print(ex.getMessage());
        }
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement stmt = con.createStatement();
            int rsCount = 0;
            String SQL = "SELECT * FROM student WHERE district='Kathmandu';SELECT * FROM student WHERE district='Salyan'";
            boolean results = stmt.execute(SQL);
            do{
                if(results){
                    ResultSet rs = stmt.getResultSet();
                    rsCount++;

                    System.out.println("RESULTSET#"+rsCount);
                    while(rs.next())
                    {
                        System.out.println(rs.getString("name")+","+rs.getString("district"));
                    }
                }
                System.out.println();
                results = stmt.getMoreResults();
            }while(results);
            stmt.close();
            con.close();
        }catch(SQLException excep)
        {
            System.out.print(excep.getMessage());
        }

    }
}

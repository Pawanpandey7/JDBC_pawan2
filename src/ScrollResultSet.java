import java.sql.*;
public class ScrollResultSet {
    public static void main(String[] args)
    {
        try{
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from student");
            System.out.println("RECORDS IN THE TABLE...");
            while(rs.next()){
                System.out.println(rs.getInt(1)+rs.getString(2));
            }
            rs.first();
            System.out.println("First record..");
            System.out.println(rs.getInt(1)+" "+rs.getString(2));
            rs.absolute(3);
            System.out.println("Third record");
            System.out.println(rs.getInt(1)+" "+rs.getString(2));
            rs.last();
            System.out.println("LAST RECORD");
            System.out.println(rs.getInt(1)+" "+rs.getString(2));
            rs.previous();
            rs.relative(-1);
            System.out.println("First Record..");
            System.out.println(rs.getInt(1)+" "+rs.getString(2));
            con.close();


        }catch(SQLException excep)
        {
            System.out.print(excep.getMessage());
        }
    }

}

import java.net.*;
import java.io.*;
public class MyClient {
    public static void main(String[] args)
    {
        try{
            Socket s = new Socket("localhost",6666);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("hello world");
            dos.flush();
            dos.close();
            s.close();
        }catch(IOException ex)
        {
            System.out.print(ex.getMessage());
        }

    }
}

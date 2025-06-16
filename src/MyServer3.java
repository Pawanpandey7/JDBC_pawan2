import java.io.*;
import java.net.*;
public class MyServer3 {
    public static void main(String[] args)
    {

       try{
           // create a socket server
           ServerSocket ss = new ServerSocket(95);
          // accept the client connection
           Socket s = ss.accept();
           //get the address of the client
           InetAddress ia = s.getInetAddress();
           String iaa = ia.getHostAddress();
           System.out.println("client is "+iaa);
           //create the reader to read the messages from the client
           BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
           //create the writer to write the message to the client
           PrintWriter out = new PrintWriter(s.getOutputStream(),true);
           //create the reader to read from the server's keyboard
           BufferedReader fsk = new BufferedReader(new InputStreamReader(System.in));
           //create a loop to to make the message exchanges
           while(true){
               //sending the message to the client
               System.out.print("Server: ");
               String sm = fsk.readLine();
               out.println(sm);
               //receive the messages from the client
               String cm = in.readLine();
               if(cm.equalsIgnoreCase("bye") || cm==null) break;
               System.out.println("client: "+cm);
           }
           ss.close();
           s.close();
           in.close();
           out.close();
       }catch(IOException ex)
       {
           System.out.println(ex.getMessage());
       }


    }
}

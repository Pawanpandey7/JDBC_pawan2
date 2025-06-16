import java.io.*;
import java.net.*;
public class MyClient3 {
    public static void main(String[] args)
    {
        try{
            //create a socket
            Socket s = new Socket("localhost",95);
            //create reader to read the messages from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //create the writer to send the messages to the server
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            //cretae a reader to read from the client keyboard
            BufferedReader rck = new BufferedReader(new InputStreamReader(System.in));
            //create a loop for the conversation
            while(true)
            {
                //get the message from the server
                String sm = in.readLine();
                if(sm.equalsIgnoreCase("bye") || sm==null) break;
                System.out.println("Server: "+sm);
                //read from the client and send it to server
                System.out.print("Client: ");
                String cm = rck.readLine();
                out.println(cm);
            }
            in.close();
            out.close();
            s.close();
        }catch(IOException ex)
        {
            System.out.print(ex.getMessage());
        }
    }
}

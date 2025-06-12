import java.io.*; // for input and output streams
import java.net.*;//for networking classes like socket
public class MyClient2 {
    public static void main(String[] args)
    {
        try{
            System.out.println("client...");
            //connect to the server running on the local host and port 95
            Socket con = new Socket("localhost",95);
            //create a reader to receive  data from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            //create a writer to send data to the server(autoFlush set to true
            PrintWriter out = new PrintWriter(con.getOutputStream(),true);
            //start a loop to exchange messages
            while(true){
                //read message form server
                String s1 = in.readLine();
                //if server says "Bye" or disconnects,exit the loop
                if(s1.equalsIgnoreCase("Bye")||s1==null) break;
                //print server's ,essage on client console
                System.out.println("From server "+s1);
                System.out.println("enter the messages to the server");
                //create a reader to read from the client's keyboard
                BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
                //read client input from console
                String st = din.readLine();
                //send message to the server
                out.println(st);
                //if client types "bye",break the loop and exit

                if(st.equalsIgnoreCase("Bye")||st==null) break;

            }
            //close all streams and sockets
            in.close();
            out.close();
            con.close();

        }catch(IOException ex)
        {
            System.out.print(ex.getMessage());
        }
    }
}

import java.io.*; // for input and output streams
import java.net.*; // for networking classes like ServerSocket, Socket and InetAddress

public class MyServer2 {
    public static void main(String[] args)
    {
        try {
            System.out.println("Server...\n");
            //create a ServerSocket listening on port 95
            ServerSocket s = new ServerSocket(95);
            System.out.println("server waiting for the client");
            //accept a client connection
            Socket cs = s.accept();
            //get client's IP Address for logging
            InetAddress ia = cs.getInetAddress();
            String cli = ia.getHostAddress();
            System.out.println("Connected to the client with IP" + cli);
            //create a reader to receive data from the client (autoFlush set to true)
            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            //create a writer to send data to client(autoFlush set to true
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
            //create a reader to read form the server's keyboard(console input)
            BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
            //start a loop to exchange messages
            do {
                System.out.print("To client:");
                //read input from the server's console
                String tocl = din.readLine();
                //send the message to the client
                out.println(tocl);
                //read the message send by the client
                String st = in.readLine();
                //if client says "Bye" or disconnects, break the loop
                if (st.equalsIgnoreCase("Bye") || st == null) break;
                //Display client's message on the server console
                System.out.println("From client " + st);
            } while (true);
            // close all streams and sockets
            in.close();
            out.close();
            cs.close();
            s.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

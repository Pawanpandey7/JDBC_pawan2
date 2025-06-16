import java.io.*;
import java.net.*;

public class MyMultiClientServer {
    //main server class
    public static void main(String[] args)
    {
        int port = 95; //server will listen on this port
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("server started. waiting for clients...");
            while(true){
                //wait for a new client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected: "+ clientSocket.getInetAddress());

                //start a new thread to handle this client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
class ClientHandler implements Runnable{
    private Socket clientSocket;
    //Constructor: stores the socket for this client;
    public ClientHandler(Socket socket){
        this.clientSocket = socket;

    }
    // this method runs in a separate thread
    public void run()
    {
        try(
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                ){
            //send welcome message to the client
            out.println("hello! you are now connected to the server");
            String message;
            //keep reading messages until client says bye
            while((message = in.readLine())!=null){
                System.out.println("Clinet says: "+message);
                out.println("echo: "+message);

                if(message.equalsIgnoreCase("Bye")){
                    break;
                }
            }
            System.out.println("client disconnected.");
            clientSocket.close(); //close the socket when done
        }catch(IOException e)
        {
            System.out.println("Connection error with client");
        }
    }


}

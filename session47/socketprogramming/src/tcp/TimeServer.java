package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer {

    public static void main(String[] args) {

      int port=9090;

        try (ServerSocket serverSocket=new ServerSocket(port)){

            System.out.println("Server is listening on port "+port);
            while (true){
                Socket socket=serverSocket.accept();
                System.out.println("New Client connected");


                OutputStream outputStream=socket.getOutputStream();
                PrintWriter printWriter=new PrintWriter(outputStream,true);
                printWriter.println(new Date().toString());

            }




        }

        catch (IOException e) {
            System.out.println("server exception"+e.getMessage());
            e.printStackTrace();
        }


    }
}

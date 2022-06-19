package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient {

    public static void main(String[] args) {
        String hostName="localhost";

        int port=9090;


        try(Socket socket= new Socket(hostName,port)) {
            InputStream input=socket.getInputStream() ;


            BufferedReader reader=new BufferedReader(new InputStreamReader(input));
            String time= reader.readLine();
            System.out.println(time);


        }
         catch (IOException e) {
            e.printStackTrace();
        }
    }
}

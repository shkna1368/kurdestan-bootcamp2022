package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) {
        try( DatagramSocket ds=new DatagramSocket()) {
            InetAddress ip=InetAddress.getLocalHost() ;

            byte buf[]=null;

            Scanner sc=new Scanner(System.in);

            while (true){
              String input=sc.nextLine();

              buf=input.getBytes();

                DatagramPacket datagramPacket=new DatagramPacket(buf, buf.length,ip,1234);

               ds.send(datagramPacket);

                if (input.equals("bye")){
                    break;
                }
            }




        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

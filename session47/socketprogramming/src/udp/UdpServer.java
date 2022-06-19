package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) {
        try( DatagramSocket ds=new DatagramSocket(1234)) {

            byte[] receive=new byte[65535];
            DatagramPacket datagramPacket=null;
            while (true){

                datagramPacket=new DatagramPacket(receive,receive.length);


                ds.receive(datagramPacket);

               StringBuilder str= converToString(receive);

                System.out.println("Client:_"+str);

                if (str.toString().equals("bye")){
                    System.out.println("client send bye");
                    break;
                }
                //clear buffer after each message
                receive=new byte[65535];


            }





        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder converToString(byte[] inputData){
        if (inputData==null)
            return null;

        StringBuilder stringBuilder=new StringBuilder();
        int i=0;
        while (inputData[i]!=0){
            stringBuilder.append((char) inputData[i]);
            i++;

        }

       return stringBuilder;
    }

}

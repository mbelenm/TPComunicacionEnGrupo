import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Udp {

    public static void sendMessage(String message, String ip) throws IOException {
        var inetAddress = InetAddress.getByName(ip);
        var buffer = message.getBytes();
        var port = 1000;

        var datagramPacket = new DatagramPacket(buffer, buffer.length, inetAddress, port);

        System.out.println("Inet address:" + datagramPacket.getAddress());
        System.out.println("Data:" + (new String(datagramPacket.getData())));
        System.out.println("Lenght:" + datagramPacket.getLength());

        var datagramSocket = new DatagramSocket(80);

        datagramSocket.setReceiveBufferSize(800);
        datagramSocket.setSendBufferSize(800);
        datagramSocket.setSoTimeout(100);
        datagramSocket.connect(inetAddress, port++);

        datagramSocket.send(datagramPacket);

        buffer = new byte[1000];
        var response = new DatagramPacket(buffer, buffer.length);
          
        datagramSocket.receive(response);
        datagramSocket.close();
        
        System.out.println("Response: " + new String(response.getData()));
    }
}

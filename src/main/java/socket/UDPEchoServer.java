package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by yanghongwu on 2017/6/14.
 */
public class UDPEchoServer {

    private static final int ECHOMAX = 255;

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Parameter(s): <Port>");
        }

        int servPort = Integer.parseInt(args[0]);
        try {
            DatagramSocket socket = new DatagramSocket(servPort);

            DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);

            while (true) {
                socket.receive(packet);
                System.out.println("Handling client at " + packet.getAddress().getHostAddress() + " on port " + packet.getPort());
                System.out.println("Received " + new String(packet.getData()));


//                packet.setData("from server".getBytes());

                byte[] resp = new byte[]{'1','2','3','4','5','6','1','2','3','4','5','6'};// 数据大于buflength那么多余字节将不会被发送;
                packet.setData(resp);

                packet.setLength(10);  // 实际发送的数据长度,还有buflength表示缓冲区大小
                socket.send(packet);

            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

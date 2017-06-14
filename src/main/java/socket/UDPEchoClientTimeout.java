package socket;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.*;

/**
 * Created by yanghongwu on 2017/6/14.
 */
public class UDPEchoClientTimeout {

    private static final int TIMEOUT = 3000;
    private static final int MAXTRIES = 5;

    public static void main(String[] args) {
        if ((args.length < 2) || (args.length > 3)) {
            throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");
        }

        try {
            InetAddress serverAddress = InetAddress.getByName(args[0]);
            byte[] bytesToSend = args[1].getBytes();
            int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(TIMEOUT);

            DatagramPacket sendPacket = new DatagramPacket(bytesToSend, bytesToSend.length, serverAddress, servPort);

            DatagramPacket receivePacket = new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);
            int tries = 0;
            boolean receiveResponse = false;
            do {
                socket.send(sendPacket);

                try {
                    socket.receive(receivePacket);

                    if (!receivePacket.getAddress().equals(serverAddress)) {
                        throw new IOException("Received packet from an unknown source");
                    }

                    receiveResponse = true;

                } catch (InterruptedIOException e) {
                    tries += 1;
                    System.out.println("Time out," + (MAXTRIES - tries) + " more tries...");
                }

            } while ((!receiveResponse) && (tries < MAXTRIES));

            if (receiveResponse) {
                System.out.println("Received: " + new String(receivePacket.getData(),"gbk"));
            } else {
                System.out.println("No response -- giving up.");
            }

            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

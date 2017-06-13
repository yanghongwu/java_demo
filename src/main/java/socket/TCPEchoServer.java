package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by yanghongwu on 2017/6/13.
 */
public class TCPEchoServer {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Parameter: <Port>");
        }

        int servPort = Integer.parseInt(args[0]);

        try {
            ServerSocket servSocket = new ServerSocket(servPort);
            int recvMsgSize;
            byte[] receiveBuf = new byte[32];

            while (true) {
                Socket clntSocket = servSocket.accept();

                SocketAddress clientAddress = clntSocket.getRemoteSocketAddress();
                System.out.println("Handling client at " + clientAddress);

                InputStream in = clntSocket.getInputStream();
                OutputStream out = clntSocket.getOutputStream();

                out.write("来自服务器端".getBytes());

                while ((recvMsgSize = in.read(receiveBuf)) != -1) {
                    String tmp = new String(receiveBuf);
                    System.out.println("Received Data : " + new String(receiveBuf));
                    out.write(receiveBuf, 0, recvMsgSize);
                    if (tmp != null && tmp.contains("EOF")) {
                        break;
                    }
                }

                out.write("EOF".getBytes());
                out.flush();
                clntSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

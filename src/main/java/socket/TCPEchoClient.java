package socket;

import com.alibaba.fastjson.util.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by yanghongwu on 2017/6/13.
 */
public class TCPEchoClient {

    public static void main(String[] args) {
        if(args.length < 2 || args.length > 3) {
            throw new IllegalArgumentException("Parameter(s) : <Server> <word> [<port>]");
        }

        String server = args[0];
        byte[] data = args[1].getBytes();
        int servPort = args.length == 3 ? Integer.parseInt(args[2]) : 7;
        try {
            Socket socket = new Socket(server, servPort);
            System.out.println("Connected to server...sending echo string");

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            out.write(data);
            out.write("EOF".getBytes());

            int totalBytestRcvd = 0;
            int bytesRcvd;
            byte[] receiveBuf = new byte[32];

//            while (totalBytestRcvd < data.length) {
//                if ((bytesRcvd = in.read(data, totalBytestRcvd, data.length - totalBytestRcvd)) == -1) {
//                    throw new SocketException("Connection Closed prematurely");
//                }
//                totalBytestRcvd += bytesRcvd;
//            }

            byte[] buffer = new byte[2048];
            int readBytes = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while((readBytes = in.read(buffer)) > 0){
                String tmp = new String(buffer, 0, readBytes);
                stringBuilder.append(tmp);
                if (tmp != null && tmp.contains("EOF")){
                    break;
                }
            }

            System.out.println("Received:" + stringBuilder.toString());
//            socket.shutdownOutput();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

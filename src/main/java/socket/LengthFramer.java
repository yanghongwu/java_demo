package socket;

import java.io.*;

/**
 * Created by yanghongwu on 2017/6/14.
 */
public class LengthFramer implements Framer {
    public static final int MAXMESSAGELENGTH = 65535;
    public static final int BYTEMASK = 0xff;
    public static final int SHORTMASK = 0xffff;
    public static final int BYTESHIFT = 8;

    private DataInputStream in;

    public LengthFramer(InputStream in) throws IOException {
        this.in = new DataInputStream(in);
    }

    @Override
    public void frameMsg(byte[] message, OutputStream out) throws IOException {
        if (message.length > MAXMESSAGELENGTH) {
            throw new IOException("message too long");
        }
        // write length prefix
        out.write((message.length >> BYTESHIFT) & BYTEMASK);
        out.write(message.length & BYTEMASK);
        // write message
        out.write(message);
        out.flush();
    }

    @Override
    public byte[] nextMsg() throws IOException {
        int length = 0;
        try {
            length = in.readUnsignedShort(); // read 2 bytes
        } catch (EOFException e) { // no (or 1 byte) message 35 return null;

        }
        byte[] msg = new byte[length];
        in.readFully(msg); // if exception, it's a framing

        return msg;
    }

    public static void main(String[] args) {
        System.out.println(8 >> 2);
        System.out.println(264 >> 8);

        System.out.println(8 & 0xff);

    }
}

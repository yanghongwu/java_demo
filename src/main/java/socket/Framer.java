package socket;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by yanghongwu on 2017/6/14.
 */
public interface Framer {
    public void frameMsg(byte[] message, OutputStream out) throws IOException;

    byte[] nextMsg() throws IOException;
}

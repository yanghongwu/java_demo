package jvm.gc;

/**
 * Created by yanghongwu on 2017/2/16.
 */
public class GCTest {

    public static void main(String[] args) {

        while (true) {
            byte[] b = null;

            for (int i = 0; i < 10; i++) {
                b = new byte[1 * 1024 * 1024];
            }
        }
    }
}

package io.pushback;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

/**
 * 探究java IO之PushbackInputStream类  https://my.oschina.net/fhd/blog/345011
 * Created by yanghongwu on 2017/3/23.
 */
public class PushbackInputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        main2();
    }

    public static void main1(String[] args) throws Exception {
        String s = "abcdefg";
        /*
         * PushbackInputStream pbin = new PushbackInputStream(in)
         * 这个构造函数创建的对象一次只能回推一个字节
         */
        try (ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
             PushbackInputStream pbin = new PushbackInputStream(in)) {
            int n;
            while ((n = pbin.read()) != -1) {
                System.out.println((char) n);
                if('b' == n) pbin.unread('1');
            }
        }
    }

    public static void main2() throws Exception {
        String s = "abcdefg";
        /*
         * PushbackInputStream pbin = new PushbackInputStream(in,4)
         * 这个构造函数创建的对象一次可以回推一个缓存
         */
        try (ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
            final PushbackInputStream pbin = new PushbackInputStream(in, 10)) {
            int n = 0 ;
            int total = 0;
            byte[] buffer = new byte[10];
            while ((n = pbin.read(buffer,0 ,buffer.length)) != -1) {
                total += n;
                System.out.println(new String(buffer));
                //取回推缓存中的一部分数据
            }
            pbin.unread(buffer,0,total);

            //--------第二次读取
            total = 0;
            buffer = new byte[10];
            while ((n = pbin.read(buffer,0 ,buffer.length)) != -1) {
                total += n;
                System.out.println(new String(buffer));
                //取回推缓存中的一部分数据
            }

        }
    }
}

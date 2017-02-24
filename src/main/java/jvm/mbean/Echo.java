package jvm.mbean;

/**
 * Created by yanghongwu on 2017/2/16.
 */
public class Echo implements EchoMBean{


    @Override
    public void print(String yourName) {
        System.out.println("Hi " + yourName + "!");
    }
}

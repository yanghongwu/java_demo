package jvm.invokedynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by yhw on 02/04/2017.
 */
public class MethodHandleTest {

    public static String age(Integer p1) {
        System.out.println("-----------> age2()" + p1);
        return "1";
    }

    public static void main(String[] args) {
        try {
            MethodType methodType = MethodType.methodType(String.class, Integer.class);
            MethodHandles.Lookup lookup = MethodHandles.lookup();

            MethodHandle mh = lookup.findStatic(MethodHandleTest.class, "age", methodType);
            Integer num = new Integer(1);
            String re = (String)mh.invokeExact(num);

            System.out.println("return " + re);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

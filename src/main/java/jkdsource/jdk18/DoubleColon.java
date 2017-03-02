package jkdsource.jdk18;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yanghongwu on 2017/3/2.
 */
public class DoubleColon {
    public static void display(String name) {
        System.out.println(name);
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("1", "2", "3");
        names.forEach(DoubleColon::display);
    }
}

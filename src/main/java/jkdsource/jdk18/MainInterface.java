package jkdsource.jdk18;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by yanghongwu on 2017/3/1.
 */
public class MainInterface {

    public static void main(String[] args) {
        OldInterface oi = new OldInterface() {
            @Override
            public double calculate() {
                System.out.println("test  20170301");
                return 0;
            }
        };

        oi.calculate();


        FunctionInterface<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

        System.out.println(converter.get("你好"));

        //
        SomeThing st = new SomeThing();
        FunctionInterface<String, String> converter2 = st::startWith;
        System.out.println(converter2.convert("aaaa"));

        //
        final int num = 1;
        FunctionInterface<String, Integer> converter3 = (from) -> Integer.valueOf(from + num);
        System.out.println("--3-->" + converter3.convert("5"));

        //
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(System.out::println);
        list.forEach(n -> System.out.println(n));

        //
//        Formula formla = (n) -> sqrt(10);

    }

}

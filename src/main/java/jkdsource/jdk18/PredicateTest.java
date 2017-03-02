package jkdsource.jdk18;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by yanghongwu on 2017/3/2.
 */
public class PredicateTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
//        condition(list, (n) -> true);

//        condition(list, (n) -> false);
//        condition(list, (n) -> n%2 == 0 );

        condition(list, (n) -> {int a = 1;return n%2 == 0;} );


    }

    public static void condition(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer i : list) {
            if (predicate.test(i)) {
                System.out.println(i + " ");
            } else {
                System.out.println("not right");
            }
        }
    }

}

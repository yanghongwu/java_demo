package jkdsource.jdk18;

/**
 * Created by yanghongwu on 2017/3/2.
 */
@FunctionalInterface
interface FunctionInterface<F,T> {

    T convert(F from);

//    T convert2(F from, String second);

    default String get(String input) {

        return input;
    }

}

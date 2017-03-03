package jkdsource.jdk18;

/**
 * Created by yanghongwu on 2017/3/3.
 */
public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}



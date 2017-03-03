package jkdsource.jdk18;

/**
 * Created by yanghongwu on 2017/3/3.
 */
public interface PersonFactory<T extends Person> {

    T create(String firstName, String lastName);

}

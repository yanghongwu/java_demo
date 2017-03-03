package jkdsource.jdk18;

/**
 * Created by yanghongwu on 2017/3/3.
 */
public class MainPersonFactory {

    public static void main(String[] args) {
        PersonFactory pf = Person::new;

        Person p = pf.create("yang", "hongwu");

        System.out.println(p.toString());
        System.out.println(p.firstName);
    }

}

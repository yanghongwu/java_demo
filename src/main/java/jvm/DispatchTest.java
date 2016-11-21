package jvm;

/**
 * Created by yhw on 11/21/2016.
 */
public class DispatchTest {

    private static final String aaaa = "en";

    private final String bbbb = "en2";

    private static String language = "en";

    static abstract class Human {

    }

    static class Woman extends Human{
        public void printOuterClassPrivateFields() {
            String fields = "language=" + language + ";";
            System.out.println(fields);
        }
    }

    static class Man extends Human{

    }


    public void sayHello(Human human) {
        System.out.println("--------------->human");
    }

    public void sayHello(Woman human) {
        System.out.println("--------------->Woman");
    }

    public void sayHello(Man human) {
        System.out.println("--------------->Man");
    }

    public static void main(String[] args) {
        DispatchTest dt = new DispatchTest();

        Human woman = new Woman();
        Human man = new Man();
        dt.sayHello(man);
        dt.sayHello((Woman)woman    );

        ((Woman) woman).printOuterClassPrivateFields();
    }
}

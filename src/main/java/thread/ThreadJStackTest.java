package thread;

/**
 * Created by yhw on 11/28/2016.
 */
public class ThreadJStackTest {
    public static void main(String[] args) throws InterruptedException {

        Shop s = new Shop();
        Thread t = getThread(s);
        t.setName("线程1");
        t.start();

        Thread t2 = getThread(s);
        t2.setName("线程2");
        t2.start();

        Thread.sleep(100000000);
    }
    private static Thread getThread(final Shop s) {
        return new Thread() {
            public synchronized void run() {
                try {
                    s.sell();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}

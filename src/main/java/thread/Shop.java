package thread;

/**
 * Created by yhw on 12/05/2016.
 */
public class Shop {

    public Shop() {

    }

    public synchronized void sell() throws InterruptedException {
        Thread.sleep(10000000);
    }

}

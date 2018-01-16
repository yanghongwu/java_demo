package guava;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.concurrent.Executors;

/**
 * Created by yanghongwu on 2017/3/6.
 */
public class AsyncEventBusTest {

    public static void main(String[] args) {
        asyncEventBus();
    }

    public static void EventBusMethod() {
        final EventBus eventBus = new EventBus();
        eventBus.register(new Object() {

            @Subscribe
            public void lister(Integer integer) {
                System.out.printf("%s from int%n", integer);
            }

            @Subscribe
            public void lister(Number integer) {
                System.out.printf("%s from Number%n", integer);
            }

            @Subscribe
            public void lister(Long integer) {
                System.out.printf("%s from long%n", integer);
            }

            @Subscribe
            public void addUser(User user) {
                System.out.println("success to add user");
            }
        });

        eventBus.post(1);
        eventBus.post(1L);

    }

    public static void asyncEventBus() {
        final AsyncEventBus aeventBus = new AsyncEventBus(Executors.newSingleThreadExecutor());


        aeventBus.register(new Object() {
            @Subscribe
            public void lister(Integer integer) {
                System.out.printf("%s from int%n", integer);
            }

            @Subscribe
            public void lister(Number integer) {
                System.out.printf("%s from Number%n", integer);
            }

            @Subscribe
            public void lister(Long integer) {
                System.out.printf("%s from long%n", integer);
            }


            @Subscribe
            public void addUser(User user) {
                System.out.println("success to add user");
            }
        });

        aeventBus.post(1);
        aeventBus.post(1L);
        aeventBus.post(new User());
    }

}

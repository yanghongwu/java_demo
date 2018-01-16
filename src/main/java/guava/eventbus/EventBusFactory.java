package guava.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * Created by yanghongwu on 2017/8/17.
 */
public class EventBusFactory {
    private static final EventBusFactory factory = new EventBusFactory();

    private final EventBus eventBus;

    private EventBusFactory() {
        eventBus = new AsyncEventBus("AsyncEventBus", Executors.newFixedThreadPool(5));
    }

    public static final EventBusFactory getDefault() {
        return factory;
    }

    public EventBus eventBus() {
        return eventBus;
    }
}

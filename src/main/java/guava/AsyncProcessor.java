package guava;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by yhw on 11/25/2016.
 */
public class AsyncProcessor {
    private static ListeningExecutorService threadPool = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

    public static <T> ListenableFuture<T> process (Callable<T> callback) {
        checkNotNull(callback);
        ListenableFuture future = threadPool.submit(callback);

        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.err.println("StringTask: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.err.println("StringTask1111: " + 1111);
            }
        });
        return future;
    }

    public static void main(String[] args) {
        AsyncProcessor.process(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("1111111111111111111");
                return null;
            }
        });
    }
}

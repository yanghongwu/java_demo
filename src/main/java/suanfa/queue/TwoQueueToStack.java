package suanfa.queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yanghongwu on 2017/7/3.
 */
public class TwoQueueToStack {

    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();


    public void push(int node) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(node);
            return;
        }

        if (queue1.isEmpty()) {
            queue2.add(node);
            return;
        }

        if (queue2.isEmpty()) {
            queue1.add(node);
            return;
        }
    }

    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return (Integer)null;
        }

        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return (Integer)null;

    }
}

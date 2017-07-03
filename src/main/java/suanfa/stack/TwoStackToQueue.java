package suanfa.stack;

import java.util.Stack;

/**
 * Created by yanghongwu on 2017/7/3.
 */
public class TwoStackToQueue {


    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();


    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }


        if (stack2.isEmpty()) {
            return  -1;
        }

        int head = stack2.pop();
        return head;
    }

    public static void main(String[] args) {
    }

}

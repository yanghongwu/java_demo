package suanfa.linkReverse;

/**
 * Created by yanghongwu on 2017/2/23.
 */
public class Node {

    private int value;
    private Node next;

    public Node(int val) {
        this.value = val;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

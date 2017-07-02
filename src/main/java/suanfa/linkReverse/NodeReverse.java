package suanfa.linkReverse;

/**
 * Created by yanghongwu on 2017/2/23.
 *
 * http://www.cnblogs.com/tina-smile/p/4878983.html
 */
public class NodeReverse {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);


//        print(head);

//        head = reverse(head);
//        print(head);

        System.out.println();

        Node nNode = new Node(-1);
//        recursion(head, nNode);
        print(nNode.getNext());

//        Node newNode = noDigui(head);
        Node newNode = digui(head);
        print(newNode);


    }

    private static void print(Node head) {
        Node h = head;
        while (null != h) {
            System.out.print(h.getValue() + " ");
            h = h.getNext();
        }
    }

    public static Node reverse(Node head) {
        if (head == null) {
            return head;
        }

        Node dummy = new Node(-1);
        dummy.setNext(head);

        Node pCur = head.getNext();
        head.setNext(null);

        while (pCur != null) {
            Node t = pCur.getNext();

            pCur.setNext(dummy.getNext());
            dummy.setNext(pCur);

            pCur = t;
        }

        return dummy.getNext();
    }

    public static Node recursion(Node head,Node nNode) {

        if (head == null || head.getNext() == null) {
            nNode.setNext(head);
            return head;
        }

        Node newNode = recursion(head.getNext(), nNode);
        head.setNext(null);
        newNode.setNext(head);

        return head;

    }

    public static Node digui(Node node) {
        if (node.getNext() == null) {
            return node;
        }

        Node nextNode = digui(node.getNext());
        System.out.println("-----" + nextNode.getValue());
        node.getNext().setNext(node);
        node.setNext(null);

        return nextNode;

    }


    public static Node noDigui(Node head) {
        Node prev = null;
        while (head != null) {
            Node tmp = head.getNext();
            head.setNext(prev);
            prev = head;
            head = tmp;
        }
        return prev;
    }

}

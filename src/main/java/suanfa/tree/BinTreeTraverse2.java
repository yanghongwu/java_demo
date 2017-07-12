package suanfa.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yanghongwu on 2017/7/3.
 */
public class BinTreeTraverse2 {

    private int[] array  = {1,2,3,4,5,6,7,8,9};

    private static List<Node> nodeList = null;

    private static class Node {
        Node leftChild;
        Node rightChild;
        int data;

        Node(int newData) {
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    public void createBinTree() {
        nodeList = new LinkedList<Node>();

        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }

        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            //左孩子
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);

            //右孩子
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
        }


        int lastParentIndex = array.length / 2 - 1;
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex * 2 + 1);

        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex * 2 + 2);

        }
    }


    public static void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    public static void main(String[] args) {
        System.out.println(9/2);
    }
}

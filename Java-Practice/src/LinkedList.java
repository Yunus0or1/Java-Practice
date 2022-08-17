import java.util.Stack;
import java.util.HashSet; // Import the HashSet class

class Node {
    private int value;
    private Node nextNode;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

class BinaryNode {
    private int value;
    private BinaryNode rightNode;
    private BinaryNode leftNode;

    public BinaryNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }
}

public class LinkedList {

    private static void printLinkedList(Node nd) {
        while (nd != null) {
            System.out.println(nd.getValue());
            nd = nd.getNextNode();
        }
    }

    public static void createBinaryTree(BinaryNode parent, BinaryNode newBnd) {
        BinaryNode entryNode = null;

        while (parent != null) {
            entryNode = parent;
            if (newBnd.getValue() > parent.getValue()) {
                parent = parent.getRightNode();
            } else if (newBnd.getValue() <= parent.getValue()) {
                parent = parent.getLeftNode();
            }
        }

        if (newBnd.getValue() > entryNode.getValue()) {
            entryNode.setRightNode(newBnd);
        }
        if (newBnd.getValue() <= entryNode.getValue()) {
            entryNode.setLeftNode(newBnd);
        }
    }

    private static void printBinaryLinkedList(BinaryNode bnd) {
        Stack<BinaryNode> stacks = new Stack<>();

        while (bnd != null) {
            System.out.println(bnd.getValue());
            bnd = bnd.getRightNode();
        }
    }

    private static void getMidValue(Node nd) {
        Node fastNode = nd;
        Node slowNode = nd;

        while (fastNode != null && fastNode.getNextNode() != null) {
            fastNode = fastNode.getNextNode().getNextNode();
            slowNode = slowNode.getNextNode();
        }

        System.out.println(slowNode.getValue());
    }

    private static Node reverseLinkedList(Node nd) {
        Node prevNode = null;

        while (nd != null) {
            Node nextNode = nd.getNextNode();
            nd.setNextNode(prevNode);
            prevNode = nd;
            nd = nextNode;
        }
        return prevNode;
    }

    private static void detectLinkedListLoop(Node nd) {
        HashSet<Node> set = new HashSet<Node>();

        while (nd != null) {
            if (set.contains(nd)) {
                System.out.print("Loop Exist");
                return;
            }
            set.add(nd);
            nd = nd.getNextNode();
        }
        System.out.print("Loop Does not Exist");
    }

    private static BinaryNode makeBTree() {
        BinaryNode bnd1 = new BinaryNode(1);
        BinaryNode bnd2 = new BinaryNode(2);
        BinaryNode bnd3 = new BinaryNode(3);
        BinaryNode bnd4 = new BinaryNode(4);
        BinaryNode bnd5 = new BinaryNode(5);
        BinaryNode bnd6 = new BinaryNode(6);

        LinkedList.createBinaryTree(bnd2, bnd4);
        LinkedList.createBinaryTree(bnd2, bnd1);
        LinkedList.createBinaryTree(bnd2, bnd3);
        LinkedList.createBinaryTree(bnd2, bnd5);
        LinkedList.createBinaryTree(bnd2, bnd6);

        return bnd1;
    }

    private static Node makeNode() {
        Node nd1 = new Node(1);
        Node nd2 = new Node(2);
        Node nd3 = new Node(3);
        Node nd4 = new Node(4);
        Node nd5 = new Node(5);
        Node nd6 = new Node(6);

        nd1.setNextNode(nd2);
        nd2.setNextNode(nd3);
        nd3.setNextNode(nd4);
        nd4.setNextNode(nd5);
        nd5.setNextNode(nd6);

        return nd1;
    }

    public static void main(String[] args) {

        Node head = LinkedList.makeNode();
        LinkedList.detectLinkedListLoop(head);

    }
}

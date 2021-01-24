package CircularList.demo;

public class Node {
    public int data;
    public Node next = this;

    public Node(int data,Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Node next) {
        this.next = next;
    }

    public Node() {

    }
}

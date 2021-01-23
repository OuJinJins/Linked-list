package Mylist.demo;
    public class Node {
        public int data;
        public Node next;

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

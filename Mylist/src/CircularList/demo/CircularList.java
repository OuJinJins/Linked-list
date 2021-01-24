package CircularList.demo;

import java.util.Scanner;

public class CircularList {
    private Node head;
    private int size;

    public CircularList() {
        head = new Node();
        this.size = 0;
    }

    public void show(){
        Node temp = this.head;
        System.out.print("链表的元素有：");
        while(temp.next != head){
            temp = temp.next;
            System.out.print(temp.data);

        }
        System.out.println();
    }

    public void insertTail(int data){
        Node node = new Node(data,this.head);
        Node temp = this.head;
        while(temp.next != head){
            temp = temp.next;
        }
        node.next = this.head;
        temp.next = node;
        this.size++;
    }

    public void insertHead(int data){
        Node node = new Node(data,head);
        node.next = this.head.next;
        this.head.next = node;
        this.size++;
    }

    public void deleteTail(){
        Node deletedNode = this.head;
        Node preNode = this.head;
        deletedNode = deletedNode.next;
        while(deletedNode.next != this.head){
            deletedNode = deletedNode.next;
            preNode = preNode.next;
        }
        preNode.next = this.head;
        deletedNode = null;
        this.size--;
    }

    public void deleteHead(){
        Node deletedNode = this.head;
        this.head.next = this.head.next.next;
        deletedNode = null;
        this.size--;
    }

    public void reverseList(int index1,int index2){
            if(index1 < 0||index2 < 0){
                System.out.println("超出范围");
                return;
            }
            if (this.size == 1||this.size == 0) return;

            Node preNode = null;
            Node node = head.next;
            Node nextNode = null;

            int del = index2 - index1;
            if (del < 0) del = -del;

            if(del+1 > this.size){
                System.out.println("超出范围");
                return;
            }
            Node firstNode = head.next;
            preNode = head.next;
            node = node.next;
            nextNode = node.next;
            for (int i = 1; i < index1 - 1;i++){
                firstNode = firstNode.next;
            }
            preNode = firstNode.next;
            node = preNode.next;
            nextNode = node.next;
            for (int j = 0;j < del;j++){
                node.next = preNode;
                preNode = node;
                node = nextNode;
                if (nextNode == head) break;
                nextNode = nextNode.next;

            }
            firstNode.next.next = node;
            firstNode.next = preNode;
    }

    public void findMid(){
        Node node = this.head.next;
        Node node2 = this.head.next;
        while(node.next != head && node.next.next != head){
            node = node.next.next;
            node2 = node2.next;
        }
        if (node.next == head && node.next.next == head)
            System.out.println("无节点");
        else{
            System.out.print("中间节点为:");
            System.out.println(node2.data);
        }
    }

    public  void  k_To_Last(){
        Node node1 = head.next;
        Node node2 = head.next;
        Scanner input =  new Scanner(System.in);
        System.out.print("要输出的倒数第k个元素数据：");
        int k = input.nextInt();
        while(k > 0&&node2 != head){
            node2 = node2.next;
            k--;
        }
        if(k > 0) {
            System.out.println("超出范围");
            return;
        }
        while(node2 != head){
            node1 = node1.next;
            node2 = node2.next;
        }
        System.out.println(node1.data);
    }

    public static void main(String[] args) {
        CircularList list = new CircularList();
        for (int i = 0; i < 10;i++){
            list.insertTail(i);
        }
        list.show();
        list.deleteTail();
        list.show();
        list.deleteHead();
        list.show();
        list.reverseList(1,3);
        list.show();
        list.deleteHead();
        list.show();
        list.findMid();
        list.k_To_Last();
    }
}

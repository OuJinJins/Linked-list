package Mylist.demo;

import java.util.Scanner;

public class MyList {
    private Node head;
    private int size;

    public MyList(){
        this.head = null;
        this.size = 0;
    }

    public void addHead(int data){
        if(head == null){
            head = new Node(data,null);
            this.size++;
            return;
        }

        Node node = new Node(data,null);
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    public void addTail(int data){
        Node node = this.head;
        if (node == null){
           this.head = new Node(data,null);
           this.size++;
           return;
        }

        while(node.next != null){
            node = node.next;
        }
        node.next = new Node(data,null);
        this.size++;
    }

    public void deleteHead(){
        if(this.head == null){
            System.out.println("无节点");
            return;
        }

        Node deletedNode = this.head;
        this.head = this.head.next;
        deletedNode = null;
        this.size--;
    }

    public void listShow(){
        Node printNode = this.head;
        System.out.print("输出所有节点：");
        while(printNode != null){
            System.out.print(printNode.data);
            System.out.print(" ");
            printNode = printNode.next;
        }
        System.out.println();
        return;
    }
    public  void deleteTail(){
        Node deletedNode = this.head;
        Node preNode = this.head;
        if(deletedNode == null){
            System.out.println("无节点");
            return;
        }

        //??
        if(this.size == 1){
            deletedNode = null;
        }
        else deletedNode = deletedNode.next;
        while(deletedNode.next != null){
            preNode = preNode.next;
            deletedNode = deletedNode.next;
        }

        deletedNode = null;
        preNode.next = null;
        this.size--;
    }

    public void reverseList(int index1,int index2){
        if(index1 < 0||index2 < 0){
            System.out.println("超出范围");
            return;
        }
        if (this.size == 1||this.size == 0) return;

        Node preNode = null;
        Node node = head;
        Node nextNode = null;

        int del = index2 - index1;
        if (del < 0) del = -del;

        if(del+1 > this.size){
            System.out.println("超出范围");
            return;
        }
        Node firstNode = head;
        preNode = head;
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
            if (nextNode == null) break;
            nextNode = nextNode.next;

        }
        firstNode.next.next = node;
        firstNode.next = preNode;
    }

    public void search(){
        Scanner input =  new Scanner(System.in);
        Node node = this.head;
        System.out.print("请输入要搜索的数据（数字0 - 9）:");
        int data = input.nextInt();
        int count = 0;
        boolean flag = false;
        while(node != null){
            if(data == node.data){
                System.out.print("存在该数据的节点下标:");
                System.out.println(count);
                flag = true;
            }
            count ++;
            node = node.next;
        }
        if(!flag){
            System.out.println("存在该数据的节点不存在");
        }
        return;
    }

    public void findMid(){
        Node node = this.head;
        Node node2 = this.head;
        while(node.next != null && node.next.next != null){
            node = node.next.next;
            node2 = node2.next;
        }
        System.out.print("中间节点为:");
        System.out.println(node2.data);
    }

    public void isCircle(){
        Node node1 = this.head;
        Node node2 = this.head;
        while(node2 != null && node1.next != null){
            node2 = node2.next.next;
            node1 = node1.next;
            if(node1 == node2){
                System.out.println("链表成环");
                return;
            }
        }
        System.out.println("链表不成环");
    }

    public  void  k_To_Last(){
        Node node1 = head;
        Node node2 = head;
        Scanner input =  new Scanner(System.in);
        System.out.print("要输出的倒数第k个元素数据：");
        int k = input.nextInt();

        while(k > 0&&node2 != null){
            node2 = node2.next;
            k--;
        }
        if(k > 0) {
            System.out.println("超出范围");
            return;
        }
        while(node2 != null){
            node1 = node1.next;
            node2 = node2.next;
        }
        System.out.println(node1.data);
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        Node head = list.head;
        Node node = new Node();
        for (int i = 0;i < 4;i++){
            list.addTail(i);
        }

        list.reverseList(2,3);
        list.listShow();
        list.search();
        list.findMid();
        list.isCircle();
        list.k_To_Last();
    }
}
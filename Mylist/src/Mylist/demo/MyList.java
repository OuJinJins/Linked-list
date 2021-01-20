package Node.demo;

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

    public void printlist(){
        Node printNode = this.head;
        while(printNode != null){
            System.out.print(printNode.data);
            printNode = printNode.next;
        }
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

    public static void main(String[] args) {
        MyList list = new MyList();
        Node head = list.head;
        Node node = new Node();
        for (int i = 0;i < 10;i++){
            list.addTail(i);
        }

        list.printlist();
        list.deleteTail();
        list.printlist();
        list.deleteHead();
        list.printlist();


    }
}
public class LL {

    private static Node head;
    private Node tail;

    private static int size;

    public LL() {
        LL.size = 0;
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public void insertAtHead(int val) {
        Node node = new Node(val);

        node.next = head;
        head = node;

        if(tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insert(int val, int index) {
        Node temp = head;

        if(index == 0) {
            insertAtHead(val);
            return;
        }

        if(index == size) {
            insertAtTail(val);
            return;
        }

        for(int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size += 1;
    }

    public void insertAtTail(int val) {
        Node node = new Node(val);

        if(tail == null) {
            insertAtHead(val);
            return;
        }

        tail.next = node;
        tail = node;

        size += 1;
    }

    ////////////////////////////////////////////////////////
    ////////Insert a node at a index using recursion////////

    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        if(index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    ////////////////////////////////////////////////////////

    public int deleteFirst() {

        if(head == null) {
            return -1;
        }

        int val = head.val;
        head = head.next;

        if(tail == null) {
            tail = head;
        }

        size -= 1;
        
        return val;
    }

    public Node getNode(int index) {
        Node node = head;

        for(int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public int delete(int index) {

        if(index == 0) {
            return deleteFirst();            
        }

        if(index == size - 1) {
            return deleteLast();
        }

        Node node = getNode(index - 1);
        Node temp = node;
        int val = temp.next.val;
        node.next = temp.next.next;

        size -= 1;

        return val;
    }

    public int deleteLast() {

        int val = tail.val;
        Node secondlast = getNode(size - 2);

        secondlast.next = null;
        tail = secondlast;

        size -= 1;
        
        return val;
    }

    public int find(int val) {
        Node temp = head;

        int index = 0;

        while (temp.val != val) {
            temp = temp.next;
            index += 1;
        }

        if(temp.val == val) {
            return index;
        }

        return -1;
    }

    ////////////////////////////////////////////////
    //////Reverse a LinkedList using Recursion//////
    public void reverse(Node node) {
        if(node == tail) {
            tail = head;
            return;
        }

        reverse(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }
    /////////////////////////////////////////////////

    public void display() {
        Node temp = head;
        
        while (temp != null) {
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        LL list = new LL();

        list.insertAtTail(4);
        list.insertAtTail(7);
        list.insertAtTail(11);
        list.insert(50, 3);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        list.insertAtHead(12);
        list.insertAtHead(2);
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(3));
        list.display();
        System.out.println(list.find(12));
        list.insertRec(33, 2);
        list.display();

        System.out.println("Size of Linked List: "+size);
        
    }
}
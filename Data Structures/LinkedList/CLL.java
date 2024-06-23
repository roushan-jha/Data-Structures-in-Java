public class CLL {

    private Node head;
    private Node tail;

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void insertEnd(int val) {
        Node node = new Node(val);

        if(head == null) {
            head = node;
            tail = node;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public Node getNode(int after) {
        Node temp = head;

        do {
            if(temp.val == after) {
                return temp;
            }
            temp = temp.next;
        } while(temp != head);

        return null;
    }

    public void insert(int val, int after) {
        Node node = new Node(val);

        Node prevNode = getNode(after);

        if(prevNode == null) {
            System.out.println("Node does not found");
            return;
        }

        if(prevNode.next == head) {
            insertEnd(val);
            return;
        }

        node.next = prevNode.next;
        prevNode.next = node;
    }

    public void delete(int val) {
        Node node = head;

        if(head == null) {
            return;
        }

        if(node.val == val) {
           head = head.next;
           tail.next = head;
           return; 
        }

        do {
            Node n = node.next;
            if(n.val == val) {
                node.next = n.next;
                break;
            }
            node = node.next;   
        } while (node != head);
    }

    public void display() {
        Node temp = head;

        do {
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("HEAD");
   }
    public static void main(String[] args) {
        CLL list = new CLL();
        list.insertEnd(8);
        list.insertEnd(4);
        list.insertEnd(12);
        list.insertEnd(1);
        list.display();
        list.insert(77, 4);
        list.display();
        list.delete(8);
        list.display();
    }
}

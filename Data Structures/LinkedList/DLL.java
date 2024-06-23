public class DLL {

    private Node head;

    private class Node {
        private int val;
        private Node next;
        private Node prev;

        public Node(int val) {
            this.val = val;
        }
    }

    public void insertFirst(int val) {
        Node node = new Node(val);

        if(head != null) {
            head.prev = node;
        }
        node.next = head;

        head = node;
    }

    public Node getNode(int after) {
        Node temp = head;

        while(temp != null) {
            if(temp.val == after) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    public void insert(int val, int after) {
        Node node = new Node(val);

        Node prevNode = getNode(after);
        if(prevNode == null) {
            System.out.println("Node does not found");
            return;
        }

        if(prevNode.next != null) {
            prevNode.next.prev = node;
        }

        node.next = prevNode.next;
        node.prev = prevNode;
        prevNode.next = node;

    }

    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;

        while(last.next != null) {
            last = last.next;
        }

        if(head != null) {
            last.next = node;
        }

        node.prev = last;
    }

    public int deleteFirst() {

        if(head == null) {
            System.out.println("Invalid!!");
            return -1;
        }

        int val = head.val;

        if(head.next != null) {
            head.next.prev = null;
        }

        head = head.next;

        return val;
    }

    public int delete(int val) {
        Node node = getNode(val);

        if(node.prev == null) {
            return deleteFirst();
        }

        if(node.next == null) {
            return deleteLast();
        }

        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;

        return val;
    }

    public int deleteLast() {
        Node last = head;

        if (head.next == null) {
            return deleteFirst();
        }

        while(last.next != null) {
            last = last.next;
        }
        int val = last.val;

        last.prev.next = null;
        last.prev = null;

        return val;
    }

    public void display() {
        Node temp = head;

        // Node last = head;

        while(temp != null) {
            System.out.print(temp.val+ " -> ");
            // last = temp;
            temp = temp.next;
        }

        System.out.println("END");

        // System.out.println("Reverse print Linked List");

        // while(last != null) {
        //     System.out.print(last.val+ " -> ");
        //     last = last.prev;
        // }

        // System.out.println("START");
    }
    public static void main(String[] args) {
        DLL list = new DLL();

        list.insertFirst(5);
        list.insertFirst(10);
        list.insertFirst(20);
        list.display();
        list.insertLast(12);
        list.insertLast(7);
        list.display();
        list.insert(55, 20);
        list.display();
        list.insert(77, 7);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        list.delete(7);
        list.display();
    }
}

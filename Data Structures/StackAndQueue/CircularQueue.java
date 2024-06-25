public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int front = 0;
    protected int rear = 0;
    private int size = 0;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if(isFull()) {
            return false;
        }

        data[rear++] = item;
        rear = rear % data.length;
        size++;
        
        return true;
    }

    public int remove() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is Empty!");
        }
        int val = data[front++];

        front = front % data.length;
        size--;

        return val;
    }

    protected boolean isFull() {
        return size == data.length;
    }

    protected boolean isEmpty() {
        return size == 0;
    }

    public int front() {
        return data[front];
    }

    public void display() {
        int i = front;

        do {
            System.out.print(data[i] +" <- ");
            i++;
            i = i % data.length;
        } while (i != rear);

        System.out.println("END");
    }

    public static void main(String[] args) throws Exception {
        
        // CircularQueue queue = new CircularQueue(5);
        DynamicQueue queue = new DynamicQueue();

        queue.insert(9);
        queue.insert(18);
        queue.insert(3);
        queue.insert(31);
        queue.insert(77);
        queue.display();
        System.out.println(queue.remove());
        queue.display();
        queue.insert(6);
        queue.display();
        System.out.println(queue.remove());
        queue.display();
        queue.insert(99);
        queue.insert(11);
        queue.display();

    }

}

class QueueLinkedList {
    private Node front;
    private Node rear;
    private int size;

    // Inner class to represent a node in the linked list
    private class Node {
        int data;
        Node next;

        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public QueueLinkedList() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Enqueue operation: Adds an element to the rear of the queue
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Enqueued: " + data);
    }

    // Dequeue operation: Removes and returns the front element of the queue
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int dequeuedData = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // Queue is empty now
        }
        size--;
        System.out.println("Dequeued: " + dequeuedData);
        return dequeuedData;
    }

    // Peek operation: Returns the front element of the queue without removing it
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display the elements of the queue
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }
        Node current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Return the size of the queue
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display(); // Output: Queue: 10 -> 20 -> 30 -> null

        System.out.println("Peek: " + queue.peek()); // Output: Peek: 10

        queue.dequeue();
        queue.display(); // Output: Queue: 20 -> 30 -> null

        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false

        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // Output: Queue is empty!
    }
}

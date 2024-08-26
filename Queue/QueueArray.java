class QueueArray {
    private int size;
    private int front;
    private int rear;
    private int[] queueArray;

    public QueueArray(int size) {
        this.size = size;
        this.front = -1;
        this.rear = -1;
        this.queueArray = new int[size];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear++;
        queueArray[rear] = data;
        System.out.println("Enqueued: " + data);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        int data = queueArray[front];
        queueArray[front] = 0; // Optional: Clear the spot

        if (front == rear) {
            front = rear = -1; // Reset the queue if it's empty after dequeue
        } else {
            front++;
        }

        System.out.println("Dequeued: " + data);
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queueArray[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();  // Output: Queue: 10 20 30

        queue.dequeue();
        queue.display();  // Output: Queue: 20 30

        System.out.println("Peek: " + queue.peek());  // Output: Peek: 20
    }
}

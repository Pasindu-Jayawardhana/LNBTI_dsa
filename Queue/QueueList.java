import java.util.LinkedList;
import java.util.List;

class QueueList {
    private List<Integer> queueList;

    public QueueList() {
        queueList = new LinkedList<>(); // LinkedList is a good choice for a queue
    }

    // Enqueue operation
    public void enqueue(int data) {
        queueList.add(data); // Adds the element to the end of the list
        System.out.println("Enqueued: " + data);
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queueList.remove(0); // Removes the element from the front of the list
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queueList.get(0); // Returns the front element without removing it
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Queue: " + queueList);
        }
    }

    public static void main(String[] args) {
        QueueList queue = new QueueList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display(); // Output: Queue: [10, 20, 30]

        queue.dequeue();
        queue.display(); // Output: Queue: [20, 30]

        System.out.println("Peek: " + queue.peek()); // Output: Peek: 20

        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // Output: Queue is empty!
    }
}

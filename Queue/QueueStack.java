import java.util.Stack;

class QueueStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int data) {
        stack1.push(data);
        System.out.println("Enqueued: " + data);
    }

    // Dequeue operation
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            // Transfer all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        int data = stack2.pop();
        System.out.println("Dequeued: " + data);
        return data;
    }

    // Peek operation
    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            // Transfer all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueStacks queue = new QueueStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Peek: " + queue.peek()); // Output: Peek: 10
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(40);
        System.out.println("Peek: " + queue.peek()); // Output: Peek: 30

        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // Output: Queue is empty!
    }
}

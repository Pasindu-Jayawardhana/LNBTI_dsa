import java.util.LinkedList;
import java.util.Queue;

public class StackTwoQueues<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public StackTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push an element onto the stack
    public void push(T element) {
        // Push the new element to queue2
        queue2.add(element);

        // Push all the remaining elements in queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Swap the names of queue1 and queue2
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop an element from the stack
    public T pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.remove();
    }

    // Peek at the top element of the stack without removing it
    public T peek() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return queue1.size();
    }

    public static void main(String[] args) {
        StackTwoQueues<Integer> stack = new StackTwoQueues<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek()); // Output: Top element is: 30
        System.out.println("Stack size is: " + stack.size());  // Output: Stack size is: 3

        System.out.println("Popped element is: " + stack.pop()); // Output: Popped element is: 30
        System.out.println("Popped element is: " + stack.pop()); // Output: Popped element is: 20

        System.out.println("Stack is empty: " + stack.isEmpty()); // Output: Stack is empty: false

        stack.push(40);
        System.out.println("Top element is: " + stack.peek()); // Output: Top element is: 40
    }
}

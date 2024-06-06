import java.util.Deque;
import java.util.ArrayDeque;

public class StackDeque<T> {

    private Deque<T> deque;

    // Constructor
    public StackDeque() {
        deque = new ArrayDeque<>();
    }

    // Push an element onto the stack
    public void push(T element) {
        deque.addFirst(element);
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return deque.removeFirst();
    }

    // Peek the top element of the stack
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return deque.peekFirst();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return deque.size();
    }

    public static void main(String[] args) {
        StackDeque<Integer> stack = new StackDeque<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack size is: " + stack.size());

        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack size is: " + stack.size());
    }
}

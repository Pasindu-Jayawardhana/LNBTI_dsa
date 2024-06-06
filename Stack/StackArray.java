public class StackArray {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize stack
    public StackArray(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    // Push an element onto the stack
    public void push(int element) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = element;
    }

    // Pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    // Peek at the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Get the size of the stack
    public int size() {
        return top + 1;
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);

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

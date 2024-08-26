class StackLinkedList {
    private Node top;

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

    public StackLinkedList() {
        this.top = null;
    }

    // Push operation: Adds an element to the top of the stack
    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println("Pushed: " + data);
    }

    // Pop operation: Removes and returns the top element of the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        System.out.println("Popped: " + poppedData);
        return poppedData;
    }

    // Peek operation: Returns the top element of the stack without removing it
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display the elements of the stack
    public void display() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return;
        }
        Node current = top;
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display(); // Output: Stack: 30 -> 20 -> 10 -> null

        System.out.println("Peek: " + stack.peek()); // Output: Peek: 30

        stack.pop();
        stack.display(); // Output: Stack: 20 -> 10 -> null

        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false

        stack.pop();
        stack.pop();
        stack.pop(); // Output: Stack is empty!
    }
}

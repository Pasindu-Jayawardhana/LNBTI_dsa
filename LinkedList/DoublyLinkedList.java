class DoublyLinkedList {
    private Node head;

    // Inner class to represent a node in the doubly linked list
    private class Node {
        int data;
        Node next;
        Node prev;

        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
    }

    // Insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        System.out.println("Inserted: " + data);
    }

    // Delete a node by value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with value " + data + " not found!");
            return;
        }

        if (current == head) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

        System.out.println("Deleted: " + data);
    }

    // Display the linked list from the front
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        System.out.print("Doubly Linked List (Forward): ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Display the linked list from the end
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        System.out.print("Doubly Linked List (Backward): ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Search for a node by value
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.displayForward();  // Output: Doubly Linked List (Forward): 10 -> 20 -> 30 -> null
        list.displayBackward(); // Output: Doubly Linked List (Backward): 30 -> 20 -> 10 -> null

        System.out.println("Search 20: " + list.search(20));  // Output: true

        list.delete(20);
        list.displayForward();  // Output: Doubly Linked List (Forward): 10 -> 30 -> null
        list.displayBackward(); // Output: Doubly Linked List (Backward): 30 -> 10 -> null

        list.delete(40); // Output: Node with value 40 not found!
    }
}

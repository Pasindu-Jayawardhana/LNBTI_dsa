class SinglyLinkedList {
    private Node head;

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

    public SinglyLinkedList() {
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
        }
        System.out.println("Inserted: " + data);
    }

    // Delete a node by value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        // If the node to be deleted is the head
        if (head.data == data) {
            head = head.next;
            System.out.println("Deleted: " + data);
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with value " + data + " not found!");
            return;
        }

        previous.next = current.next;
        System.out.println("Deleted: " + data);
    }

    // Display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
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
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();  // Output: Linked List: 10 -> 20 -> 30 -> null

        System.out.println("Search 20: " + list.search(20));  // Output: true

        list.delete(20);
        list.display();  // Output: Linked List: 10 -> 30 -> null

        list.delete(40); // Output: Node with value 40 not found!
    }
}

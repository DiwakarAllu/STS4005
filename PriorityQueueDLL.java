import java.util.*;

class Node {
    int data;
    int priority;
    Node prev, next;

    public Node(int data, int priority) {
        this.data = data;
        this.priority = priority;
        this.prev = null;
        this.next = null;
    }
}

public class PriorityQueueDLL {
    Node head = null, tail = null; 

    // Method to insert a new node ------- T.c = O(n)   S.c = O(1)
    public void push(int data, int priority) {
        Node newNode = new Node(data, priority);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node current = head;
            while (current != null && current.priority <= priority) {
                current = current.next;
            }
            if (current == head) {
                // Insert at the beginning
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (current == null) {
                // Insert at the end
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                // Insert in the middle
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
    }

    // Method to remove the element with the highest priority ------- T.c = O(1)
    public int pop() {
        if (head == null) {
            System.out.println("Priority Queue is empty");
            return -1;
        }

        int data = head.data;  
        head = head.next; 

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;  // If the list becomes empty, reset tail
        }
        return data;
    }

    // Method to peek at the element with the highest priority --------- T.c = O(1)
    public int peek() {
        if (head == null) {
            System.out.println("Priority Queue is empty");
            return -1;
        }

        return head.data; 
    }

    // Method to check if the priority queue is empty ------- T.c = O(1)
    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueueDLL pq = new PriorityQueueDLL();

        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();

        System.out.println("Enter the elements (data and priority):");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            int priority = sc.nextInt();
            pq.push(data, priority);
        }

        System.out.println("Elements in priority order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.pop());
        }
    }
}

import java.util.*;

class Node {
    int data;
    int pr;
    Node prev;
    Node next;

    Node(int n, int pri) {
        data = n;
        pr = pri;
        prev = null;
        next = null;
    }
}

public class PriorityQueueUsingDLL {
    static Node front = null;
    static Node rear = null;

    static void insert(int n, int prio) {
        Node newNode = new Node(n, prio);
        if (front == null) {
            front = newNode;
            rear = newNode;
        }

        else if (prio < front.pr) {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }

        else {
            Node temp = front;
            while (temp.next != null && temp.next.pr <= prio) {
                temp = temp.next;
            }

            if (temp.next == null) {
                temp.next = newNode;
                newNode.prev = temp;
                rear = newNode;
            }

            else {
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
            }
        }
    }

    static void display() {
        Node curr = front;
        while (curr != null) {
            System.out.print("(" + curr.data + ", p=" + curr.pr + ")");
            if (curr.next != null)
                System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            int d = sc.nextInt();
            insert(c, d);
        }
        display();
        sc.close();
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
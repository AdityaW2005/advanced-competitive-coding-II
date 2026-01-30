import java.util.Scanner;

class List {
    Node head = null;

    class Node {
        int data;
        Node next;

        Node(int n) {
            data = n;
            next = null;
        }
    }

    void insert(int n) {
        Node newNode = new Node(n);
        if (head == null)
            head = newNode;
        else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    void seg() {
        Node es = null;
        Node ee = null;
        Node os = null;
        Node oe = null;
        Node curr = head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (es == null)
                    es = ee = curr;
                else {
                    ee.next = curr;
                    ee = curr;
                }
            } else {
                if (os == null)
                    os = oe = curr;
                else {
                    oe.next = curr;
                    oe = curr;
                }

            }
            curr = curr.next;
        }

        if (es == null)
            head = os;
        else {
            head = es;
            ee.next = os;
        }
        oe.next = null;
    }
}

public class SegregationOfOddAndEvenInLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List l = new List();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            l.insert(sc.nextInt());
        l.display();
        l.seg();
        System.out.println();
        l.display();
        sc.close();
    }
}

// Time Complexity: O(n ^ 2)
// Space Complexity: O(n)
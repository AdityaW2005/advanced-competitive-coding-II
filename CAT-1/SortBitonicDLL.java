import java.util.*;

class List {
    Node head = null;

    class Node {
        int data;
        Node prev, next;

        Node(int n) {
            data = n;
            prev = next = null;
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
            newNode.prev = curr;
        }
    }

    void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " <--> ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    void bit() {
        Node first = head;
        Node last = head;
        Node res = null;
        Node resend = null;

        while (last.next != null)
            last = last.next;

        while (first != last) {
            if (first.data <= last.data) {
                if (res == null) {
                    res = resend = first;
                    first = first.next;
                } else {
                    Node curr = first.next;
                    resend.next = first;
                    first.prev = resend;
                    curr.prev = null;
                    first = curr;
                    resend = resend.next;
                }
            }

            else {
                if (res == null) {
                    res = resend = last;
                    last = last.prev;
                } else {
                    Node curr = last.prev;
                    resend.next = last;
                    last.prev = resend;
                    curr.next = null;
                    last = curr;
                    resend = resend.next;
                }
            }
        }

        resend.next = first;
        first.prev = resend;
        head = res;
    }
}

public class SortBitonicDLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List l = new List();
        for (int i = 0; i < n; i++)
            l.insert(sc.nextInt());
        l.display();
        System.out.println();
        l.bit();
        l.display();
        sc.close();
    }
}

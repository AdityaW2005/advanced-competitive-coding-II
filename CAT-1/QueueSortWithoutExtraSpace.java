import java.util.*;

public class QueueSortWithoutExtraSpace {
    static int min(Queue<Integer> q, int limit) {
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        int n = q.size();

        for (int i = 0; i < n; i++) {
            int curr = q.poll();
            if (curr <= minVal && i < limit) {
                minVal = curr;
                minIndex = i;
            }

            q.add(curr);
        }

        return minIndex;
    }

    static void insertAtEnd(Queue<Integer> q, int minIndex) {
        int minVal = 0;
        int n = q.size();

        for (int i = 0; i < n; i++) {
            int curr = q.poll();
            if (i != minIndex)
                q.add(curr);
            else
                minVal = curr;
        }

        q.add(minVal);
    }

    static void sort(Queue<Integer> q) {
        for (int i = 0; i < q.size(); i++) {
            int minIndex = min(q, q.size() - i);
            insertAtEnd(q, minIndex);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            q.add(sc.nextInt());

        sort(q);

        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }

        sc.close();
    }
}

// Time Complexity: O(n ^ 2)
// Space Complexity: O(1)
import java.util.*;

public class StackPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < n; i++)
            q1.add(sc.nextInt());

        for (int i = 0; i < n; i++)
            q2.add(sc.nextInt());

        Stack<Integer> st = new Stack<>();

        while (!q1.isEmpty()) {
            int ele = q1.poll();

            if (ele == q2.peek()) {
                q2.poll();

                while (!st.isEmpty() && st.peek() == q2.peek()) {
                    st.pop();
                    q2.poll();
                }
            } else {
                st.push(ele);
            }
        }

        if (q1.isEmpty() && st.isEmpty())
            System.out.print("Yes");
        else
            System.out.print("No");

        sc.close();
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
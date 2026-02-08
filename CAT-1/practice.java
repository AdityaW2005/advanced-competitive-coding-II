import java.util.*;

public class practice {
    static void span(int p[], int n, int s[]) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        s[0] = 1;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && p[st.peek()] <= p[i]) {
                st.pop();
            }

            s[i] = (st.isEmpty() ? (i + 1) : (i - st.peek()));
            st.push(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = sc.nextInt();
        int s[] = new int[n];
        for (int i = 0; i < n; i++)
            System.out.print(s[i] + " ");
        sc.close();
    }
}
import java.util.*;

public class CelebrityProblem {
    static void celeb(int c[][], int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++)
            st.push(i);

        while (st.size() >= 2) {
            int a = st.pop();
            int b = st.pop();
            if (c[a][b] == 1)
                st.push(b);
            else
                st.push(a);
        }

        int pc = st.pop();
        boolean temp = true;
        for (int i = 0; i < n; i++) {
            if (i != pc) {
                if (c[i][pc] == 0 || c[pc][i] == 1) {
                    temp = false;
                    break;
                }
            }
        }

        if (temp) {
            System.out.print("Celebrity is: " + pc);
            return;
        }

        else {
            System.out.print("No Celebrity found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        }
        celeb(a, n);
        sc.close();
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
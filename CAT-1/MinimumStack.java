import java.util.*;

public class MinimumStack {
    static Stack<Integer> st = new Stack<>();
    static Stack<Integer> mst = new Stack<>();

    static void push(int n) {
        if (st.isEmpty()) {
            st.push(n);
            mst.push(n);
        }

        else {
            st.push(n);
            if (n <= mst.peek())
                mst.push(n);
        }
    }

    static void pop() {
        int ele = st.pop();
        if (ele == mst.peek())
            mst.pop();
    }

    static void getMin() {
        if (mst.isEmpty())
            System.out.print("Stack is empty");
        else
            System.out.print(mst.peek());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            push(sc.nextInt());
        getMin();
        sc.close();
    }
}

// Time Complexity: O(1)
// Space Complexity: O(n)
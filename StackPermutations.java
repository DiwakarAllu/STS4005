import java.util.*;

public class StackPermutations { // T.c = O(n)     s.c = O(n)
    private static boolean isStackPermutation(Queue<Integer> iq, Queue<Integer> oq) {
        Stack<Integer> s = new Stack<>();
        while (!iq.isEmpty()) {
            int curr = iq.poll();
            s.push(curr);
            while (!s.isEmpty() && s.peek() == oq.peek()) {
                s.pop();
                oq.poll();
            }
        }
        return oq.isEmpty() && s.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> iq = new LinkedList<>();
        Queue<Integer> oq = new LinkedList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            iq.add(sc.nextInt());
        }
        for (int j = 0; j < n; j++) {
            oq.add(sc.nextInt());
        }

        System.out.println(isStackPermutation(iq, oq) ? "True" : "False");
    }
}

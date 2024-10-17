import java.util.*;

public class SortingQueueWithoutExtraSpace { // T.c = O(n^2)    s.c = O(1)

   static void sorting(Queue<Integer> q) {
        int n = q.size();
        for (int i = 0; i < n; i++) {
            int minI = findMinIndex(q, n - i - 1);
            insertAtEnd(q, minI);
        }
    }
  
    static int findMinIndex(Queue<Integer> q, int tillIdx) {
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;
        int n = q.size();
        for (int i = 0; i < n; i++) {
            int curr = q.poll();
            if (i <= tillIdx && curr < minVal) {
                minIdx = i;
                minVal = curr;
            }
            q.offer(curr);
        }
        return minIdx;
    }

    static void insertAtEnd(Queue<Integer> q, int minI) {
        int n = q.size();
        int minV = 0;
        for (int i = 0; i < n; i++) {
            int curr = q.poll();
            if (i == minI) {
                minV = curr;
            } else {
                q.offer(curr);
            }
        }
        q.offer(minV);
    }

   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            q.offer(sc.nextInt());
        }

        sorting(q);

        System.out.println("Sorted Queue is: " + q);
    }
}

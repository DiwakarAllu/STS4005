import java.util.Scanner;
import java.util.Stack;

public class CelebrityFinder { // ----------- T.c = O(n) && S.c =  O(n)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of people:");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        System.out.println("Enter the matrix (one row at a time):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            s.push(i);
        }

        while (s.size() > 1) {
            int x = s.pop();
            int y = s.pop();
            if (arr[x][y] == 1) {
                s.push(y);
            } else {
                s.push(x);
            }
        }

        int res = s.pop();
        for (int i = 0; i < n; i++) {
            if (i != res && (arr[res][i] == 1 || arr[i][res] == 0)) {
                System.out.println("No celebrity");
                return;
            }
        }
        System.out.println("Celebrity is " + res);
    }
}

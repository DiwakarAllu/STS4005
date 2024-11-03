// https://leetcode.com/problems/find-pivot-index/

class MaxEquilibrium { //------------t.c: O(n) && s.c: O(1)
    public static void main(String[] args) {
        int[] arr = { -2, 5, 3, 1, 2, 6, -4, 2 };
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }

        int prevsum = 0;
        for (int i = 0; i < n; i++) {
            prevsum = prevsum + arr[i];
            if (sum == prevsum) {
                System.out.println(i + "-> sum = " + sum);
            }
            sum = sum - arr[i];
        }
        System.out.println();
    }
}

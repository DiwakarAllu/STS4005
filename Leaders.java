// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

class Leaders {
    public static void main(String[] args) {
        int[] arr = { 1, 11, 2, 8, 5, 4 };
        int n = arr.length;

        int max_from_right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max_from_right) {
                max_from_right = arr[i];
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

}

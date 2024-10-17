import java.util.*; 

public class StockSpan { // -------------  t.c = O(n) s.c = O(n)

    static void findStackSpan(int[] prices) { 
        Stack<Integer> s = new Stack<>();
        int[] span = new int[prices.length];
        s.push(0); // index is pushed to stack initially
        span[0] = 1; // Span for the first element is always 1

        for (int i = 1; i < prices.length; i++) {
            while (!s.isEmpty() && prices[i] >= prices[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            // span[i] = (s.isEmpty()) ? (i + 1) : (i - s.peek());
            s.push(i);
        }

        for (int j : span)
            System.out.print(j + " ");
    }

    static void findStockSpan(int[] prices) { //--------- T.c = O(n^2)
        int[] span = new int[prices.length];
        span[0] = 1; // The span for the first day is always 1

        for (int i = 1; i < prices.length; i++) {
            span[i] = 1; // Start with span of 1 for the current day

            // Check previous days
            for (int j = i - 1; j >= 0; j--) {
                if (prices[i] >= prices[j]) {
                    span[i]++; // Increment span if the price is greater or equal
                } else {
                    break; // Stop if a higher price is found
                }
            }
        }

        //  Print the spans
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of days:");
        int n = sc.nextInt();
        
        int[] prices = new int[n];

        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        // Calculate and print the stock spans
        findStackSpan(prices);
    }
}

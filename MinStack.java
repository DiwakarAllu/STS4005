import java.util.Scanner;
import java.util.Stack;

class MinStack {
    private static Stack<Integer> s = new Stack<>();
    private static Stack<Integer> ms = new Stack<>();

    public static void push(int ele) {
        s.push(ele);
        if (ms.isEmpty() || ms.peek() >= ele) {
            ms.push(ele);
        }
    }

    public static void pop() {
        if (!s.isEmpty()) {
            int x = s.pop();
            if (x == ms.peek()) {
                ms.pop();
            }
        }
    }

    public static int top() {
        if (!s.isEmpty()) {
            return s.peek();
        }
        return -1; // Return -1 if the stack is empty
    }

    public static int getMin() {
        if (!ms.isEmpty()) {
            return ms.peek();
        }
        return -1; // Return -1 if the minimum stack is empty
    }

    public static boolean isEmpty() {
        return s.isEmpty();
    }
//------------------------------------------------------
  static class MinStack2{ //------------- T.c = O(1)  &&  S.c = O(1)
        Stack<Long> stack = new Stack<>();
        long min = Long.MAX_VALUE;

        public void push(long val) {
            if (stack.isEmpty()) {
                stack.push(val);
                min = val;
            } else {
                if (min > val) {
                    // encode
                    stack.push(2 * val - min);
                    min = val;
                } else {
                    stack.push(val);
                }
            }
        }

        public void pop() {
            if (stack.isEmpty())
                return;
            long ele = stack.pop();
            if (ele < min) {
                // decode
                min = 2 * min - ele;
            }
        }

        public long top() {
            if (stack.peek() <= min) {
                // return 2*min-stack.peek();
                return min;
            } else {
                return stack.peek();
            }
        }

        public long getMin() {
            return min;
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an operation: 1 (Push), 2 (Pop), 3 (Top), 4 (GetMin), 5 (IsEmpty), 6 (Exit)");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter element to push:");
                    int ele = sc.nextInt();
                    push(ele);
                    break;
                case 2:
                    pop();
                    System.out.println("Element popped");
                    break;
                case 3:
                    System.out.println("Top element: " + top());
                    break;
                case 4:
                    System.out.println("Minimum element: " + getMin());
                    break;
                case 5:
                    System.out.println("Is stack empty? " + isEmpty());
                    break;
                case 6:
                    sc.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}

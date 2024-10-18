
import java.util.*;
class LoopDetection{ // ---------- t.c = O(n) and s.c = O(1)

    static class Node{
         int data;
         Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    static Node head=null,tail=null;

    static void push(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
            //tail.next=newNode;
           // tail=newNode;
        }
    }
    
    static boolean isCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow =slow.next;
            fast=fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
            push(arr[i]);
        }
        // tail.next = head;
        if(isCycle(head)){
            System.out.println("Cycle Detected");
        }else{
            System.out.println("No Cycle Detected");
        }
    }

}

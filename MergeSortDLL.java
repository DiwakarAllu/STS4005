
import java.util.*;

class MergeSortDLL{ // T.c = O(nlogn)  and  S.c = O(1) recursive stack space = O(logn)
    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    static Node head=null,tail=null;
    
    static void push(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
    }
    
    static Node split(Node head){
        Node slow=head;
        Node fast=head;

        while(fast.next!=null && fast.next.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node temp=slow.next;
        slow.next.prev=null;
        slow.next=null;
        return temp;
    }
    
    static Node merge(Node first,Node second){
        if(first==null){
            return second;
        }
        if(second==null){
            return first;
        }
        if(first.data<second.data){
            first.next=merge(first.next,second);
            first.next.prev=first;
            return first;

        } else{
            second.next=merge(first,second.next);
            second.next.prev=second;
            return second;
        }
    }

    static void printdll(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    
    static Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node second = split(head);
        head = mergeSort(head);
        second = mergeSort(second);
        return merge(head,second);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            push(arr[i]);
        }
       // printdll(head);
        head=mergeSort(head);
        System.out.println();
        printdll(head);
        System.out.println();
    }

}

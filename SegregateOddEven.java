
import java.util.*;
class SegregateOddEven{ // --------- t.c = O(n)  && s.c = O(1)
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
            tail.next=newNode;
            tail=newNode;
        }
    }
    
    static void segregateEvenOdd(){
        Node evenHead=null,evenTail=null,oddHead=null,oddTail=null;
        Node temp=head;
        while(temp!=null){
            if(temp.data%2==0){
                if(evenHead==null){
                    evenHead=temp;
                    evenTail=temp;
                }else{
                    evenTail.next=temp;
                    evenTail=temp;
                }
            }else{
                if (oddHead == null) {
                    oddHead = temp;
                    oddTail = temp;
                } else {
                    oddTail.next = temp;
                    oddTail = temp;
                }
            }
            temp=temp.next;
        }

        head=evenHead;
        evenTail.next=oddHead;
        tail=oddTail;

        printlist(head);
    }

    static void printlist(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
            push(arr[i]);
        }
        segregateEvenOdd();
        System.out.println();
    }
}

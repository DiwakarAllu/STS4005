import java.util.*;

public class TowerOfHanoi{ // -------------t.c = O(2^n)   s.c = O(n)

    static void towerOfHanoi2(int n,char from_rod,char to_rod,char aux_rod){
        if(n==0){
            return;
        }
        towerOfHanoi2(n-1, from_rod, aux_rod,to_rod);
        System.out.println("Move disk "+n+ "from "+from_rod+" to "+to_rod);
        towerOfHanoi2(n-1, aux_rod,to_rod,from_rod);
    }
    //--------------------------------------------------------------------------
    static void steps(int x,char s,char d){
        //System.out.println("Move disk "+x+" from "+s+" to "+d);
        System.out.print(s);
        System.out.println(d);
    }

    static void validate(Stack<Integer>s1,Stack<Integer>s2,char s,char d){
        if(s1.isEmpty() && !s2.isEmpty()){
            int x=s2.pop();
            s1.push(x);
            steps(x,d,s);
        }else if(!s1.isEmpty() && (s2.isEmpty() || s1.peek()<s2.peek())){
            int x=s1.pop();
            s2.push(x);
            steps(x,s,d);
        }else if(!s2.isEmpty() && (s1.isEmpty() || s2.peek()<s1.peek())){
            int x=s2.pop();
            s1.push(x);
            steps(x,d,s);
        }
    }
    static void towerOfHanoi(int n){
        Stack<Integer>src=new Stack<>();
        Stack<Integer> dest = new Stack<>();
        Stack<Integer> aux = new Stack<>();

        for(int i=n;i>=1;i--){
            src.push(i);
        }

        char s='S',d='D',a='A';
        if(n%2==0){
            char temp=d;
            d=a;
            a=temp;
        }

        for(int i=1;i<=(int)Math.pow(2, n)-1;i++){
            if(i%3==1){
                validate(src,dest,s,d);
            }else if(i%3==2){
                validate(src,aux,s,a);
            }else{
                validate(aux,dest,a,d);
            }
        }
    }
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int n = sc.nextInt();
      towerOfHanoi(n);
    }
}

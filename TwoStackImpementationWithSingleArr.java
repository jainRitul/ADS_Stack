
class Twostack1 {
   
   int arr[];
   int cap;
   int top1;
   int top2;
   Twostack1(int n){
    arr = new int[n];
    cap = n;
    top1  = cap / 2 + 1;
    top2 = cap/2;
   }
   void push1(int x){
      if(top1 > 0){
         top1--;
         arr[top1] = x;
      }else{
          System.out.println("Stack overflow 1");
          return;
      }
   }
   void push2(int x){
    if(top2 < cap-1){
        top2++;
        arr[top2] = x;
     }else{
         System.out.println("Stack overflow 2");
         return;
     }
   }
   int pop1(){
     if(top1 <= cap/2){
        int x = arr[top1];
        top1++;
        return x;
     }
     else{
        System.out.println("Stack underflow 1 ");
        System.exit(1);
     }
     return 0;
   }
   int pop2(){
    if(top2 > cap/2){
        int x = arr[top2];
        top2--;
        return x;
     }
     else{
        System.out.println("Stack underflow 2 ");
        System.exit(1);
     }
     return 0;
   }
}
public class TwoStackImpementationWithSingleArr {

    public static void main(String[] args) {
        Twostack1 t = new Twostack1(5);
        t.push1(1);
        t.push2(2);
        t.push1(3);
        t.push2(4);
        t.push1(5);
        System.out.println("Popped Item from 1 " + t.pop1());
        System.out.println("Popped Item from 2 " + t.pop2());
        System.out.println("Popped Item  from 1 " + t.pop1());
        System.out.println("Popped Item from 2 " + t.pop2());
        System.out.println("Popped Item from 1 " + t.pop1());
        System.out.println("Popped Item from 2 " + t.pop2());
        // System.out.println("Size of stack 1 " + t.size1());
        // System.out.println("Size of stack 2 " + t.size2());
    }
}
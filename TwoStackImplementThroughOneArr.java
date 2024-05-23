import java.io.*;
import java.util.*;

class Twostack  {
    int arr[];
    int cap;
    int top1,top2;

    Twostack(int n){
        arr = new int[n];
        cap = n;
        top1 = -1;
        top2 = cap;
    }
    void push1(int x){
        if(top1 < top2-1){
            top1++;
            arr[top1]  = x;
        }
        else{
        System.out.println("Stack overflow");
        System.exit(0);}
    }
    void push2(int x){
        if(top1 < top2-1){
            top2--;
            arr[top2]  = x;
        }else{
        System.out.println("Stack overflow");
        System.exit(0);}
    }
    int pop1(){
      if(top1 >=0){
        int x = arr[top1];
        top1--;
        return x;
      }
      else{
        System.out.println("Stack underflow");
        System.exit(1);
      }
      return 0;
    }
    int pop2(){
        if(top2 < cap){
            int x = arr[top2];
            top2++;
            return x;
          }
          else{
            System.out.println("Stack underflow");
            System.exit(1);
          }
          return 0;
    }
    int size1(){
       return top1+1;
    }
    int size2(){
     return cap-top2;
    }

}
public class TwoStackImplementThroughOneArr{
    public static void main(String[] args) {
        Twostack t = new Twostack(5);
        t.push1(1);
        t.push2(2);
        t.push1(3);
        t.push1(4);
        t.push2(5);
        System.out.println("popped item from s1 " + t.pop1());
        System.out.println("popped item from s1 " + t.pop1());
        System.out.println("popped item from s2 " + t.pop2());
        System.out.println("popped item from s2 " + t.pop2());
        // System.out.println("popped item from s2 " + t.pop2());
        System.out.println("Size of s1 " + t.size1());
        System.out.println("Size of s2 " + t.size2());
    }
}
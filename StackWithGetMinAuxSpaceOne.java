import java.util.Stack;

class Mystack{
    Stack<Integer>s;
    int min;
    Mystack(){
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    void push(int x){
       if(s.isEmpty())
       {
          min = x;
          s.push(x);
       }
       else if(min >= x)
       {
         s.push(x-min);
         min = x;
        }
        else s.push(x);
      
    }
    int pop(){
       
        int x = s.pop();
        if(x <= 0){
           int res = min;
           min =min-x;
           return res;
        }
        else 
        return x;
    }
    int getMin(){
        return min;
    }
    int top(){
        return s.peek();
    }
}
public class StackWithGetMinAuxSpaceOne {
    public static void main(String[] args) {
        Mystack s = new Mystack();
        s.push(3);
        s.push(2);
        s.push(10);
        s.push(1);
        s.push(6);
        s.push(9);
        System.out.println(s.pop() + " ");
        System.out.println(s.pop() + " ");
        System.out.println(s.getMin());
        System.out.println(s.pop() + " ");
        System.out.println(s.pop() + " ");
        System.out.println(s.getMin());
        System.out.println(s.pop() + " ");
        // System.out.println(s.getMin());

    }
}

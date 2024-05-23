import java.util.Stack;

class MyStack {
    Stack<Integer>s;
    Stack<Integer>as;

    MyStack(){
        s = new Stack<>();
        as = new Stack<>();
    }

    void push(int x){
        if(s.isEmpty()){
            as.push(x);
        }
        s.push(x);

        if(as.peek() >= s.peek())
        as.push(x);

    }
    int pop(){
       if(s.isEmpty()){
        return -1;
       }
       if(s.peek() == as.peek()){
        as.pop();
       }
       return s.pop();
    }
    int getMin(){
       return as.peek();
    }
    int top(){
        return s.peek();
    }
}
public class StackWIthGetMin {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(10);
        s.push(1);
        s.push(2);
        s.push(4);
        s.push(6);
        s.push(18);
        s.push(5);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.getMin());        System.out.println(s.pop());
        System.out.println(s.getMin());
    }
}

import java.util.Stack;

public class EvaluationOfPrefix {
    public static void main(String[] args) {
        String str = "+*1023";
        System.out.println(expressionVal(str));
    }
    static int expressionVal(String str){
        int n=str.length();

        Stack<Integer>s = new Stack<>();

        for(int i = n-1;i>=0;i--){
           char c = str.charAt(i);

           if(Character.isDigit(c)){
            s.push(c-'0');
           }
           else{
            int op1 = s.pop();
            int op2 = s.pop();
            
            if(c == '+'){
                s.push(op1 + op2);
            }else if(c=='-'){
                s.push(op1 - op2);
            }else if(c=='*'){
                s.push(op1 * op2);
            }
            else s.push(op1/op2);
           }
        }return s.peek();
    }
}

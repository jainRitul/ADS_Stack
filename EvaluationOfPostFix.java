import java.util.Stack;

public class EvaluationOfPostFix {
    public static void main(String[] args) {
        String str = "231*+9-";

        System.out.println(evaluationOfPostfix(str));
    }
    static int evaluationOfPostfix(String str){
        int n = str.length();
        int result = 0;
        Stack<Integer>s = new Stack<>();
        for(int i = 0;i<n;i++){
            char c = str.charAt(i);
            if(c >='0' && c <= '9'){
                s.push(c - '0');
            }
            else{
               int op1 = (int)s.pop();
               int op2 = (int)s.pop();
               if(c == '+'){
                 result = op1 + op2;
               
               }else if(c=='-'){
                result = op2 - op1;
                
               }else if(c== '*'){
                result = op2 * op1;
               }
               else {
                result = op2/op1;
               }
                 s.push(result);
            }
        }
        return s.peek();
    }
}

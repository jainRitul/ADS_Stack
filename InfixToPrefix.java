import java.util.Stack;

public class InfixToPrefix {

    public static void main(String[] args) {
        String str = "(A-B/C)*(A/K-L)";

        System.out.println(prefix(str));
    }
    static int prec(char c){
        if(c == '^') return 3;
        else if(c=='*' || c=='/') return 2;
        else if(c=='+' || c=='-') return 1;
        else return 0;
    }
   

    static String prefix(String str){
        int n = str.length();

        Stack<Character>s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i =n-1;i>=0;i--){
            char c = str.charAt(i);

            if(Character.isLetterOrDigit(c))
              sb.append(c);
            else if(c == ')')
              s.push(c);
            else if(c == '('){
                while (s.peek() != ')') {
                    sb.append(s.peek());
                    s.pop();
                }
                s.pop();
            } 
            else {
                while (!s.isEmpty() && prec(c) <=  prec(s.peek())) {
                    sb.append(s.peek());
                    s.pop();
                }
                s.push(c);
            } 
        }
        while (!s.isEmpty()) {
            sb.append(s.peek());
            s.pop();
        }
        return sb.reverse().toString();
    }
}

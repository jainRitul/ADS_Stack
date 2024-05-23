import java.util.Stack;

public class InfixToPostfix {
 public static void main(String[] args) {
    String exp = "a+b*(c^d-e)^(f+g*h)-i";
    System.out.println(infixToPost(exp));
 }   
 static int prec(char c){
    if(c == '^') return 3;
    else if (c=='*' || c =='/')return 2;
    else if(c=='+' || c=='-') return 1;
    else return -1;
 }
 static String infixToPost(String exp){
    int n = exp.length();
    String ans="";
    Stack<Character>s = new Stack<>();

    for(int i =0;i<n;i++)
    {
        char c = exp.charAt(i);
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')){
            ans += c;
        }
        else if(c == '('){
            s.push(c);
        }
        else if(c==')'){
            while (s.peek() != '(') {
                ans += s.peek();
                s.pop();
            }
            s.pop();
        }
        else {
            while (!s.isEmpty() && prec(c) <= prec(s.peek()) ) 
                ans += s.pop(); 
            s.push(c);
        }
    }
    while (!s.isEmpty()) {
        ans += s.pop();
    }return ans;
 }
}

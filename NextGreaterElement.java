import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {5,15,10,8,6,12,18};
        findNextGreater(arr);System.out.println();
        findNextGreaterEfficient(arr);
    }
    public static void findNextGreaterEfficient(int arr[])
    {
      int n = arr.length;
      ArrayList<Integer>a = new ArrayList<>();
      Stack<Integer>s = new Stack<>();
      s.push(arr[n-1]);
      a.add(-1);
      for(int i = n-2;i>=0;i--){
          while(!s.isEmpty() && s.peek()<= arr[i]){
             s.pop();
          }
          int nextG = s.isEmpty() ? -1 : s.peek();
          a.add(nextG);
          s.push(arr[i]);
      }
      Collections.reverse(a);

      for(int i = 0;i<a.size();i++)
       System.out.print(a.get(i) + " ");
    }
    public static void findNextGreater(int arr[]){
       int n = arr.length;

        for(int i = 0;i<n-1;i++)
        {
                for(int j = i+1;j<n;j++)
                {
                    if(arr[i] < arr[j]){
                        System.out.print(arr[j] + " ");
                        break;
                    }
                }
        }
        System.out.print(-1 + " ");
    }
}

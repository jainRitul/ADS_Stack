import java.util.Stack;

public class LargestRectangularAreaBetter {
    public static void main(String[] args) {
        int arr[] = {6,2,5,4,1,5,6};
        int n = arr.length;

        System.out.println(findLargestHistogramArea(arr,n));
    }
    static int findLargestHistogramArea(int arr[],int n){
        int ps[] = new int[n];
        int ns[] = new int[n];
        Stack<Integer>s = new Stack<>();
        s.add(0);
        for(int i= 0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i] ){
                s.pop();
            }
 
            ps[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        while(!s.isEmpty())
            s.pop();
        s.push(n-1);
        for(int i= n-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i] ){
                s.pop();
            }
 
            ns[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int curr = arr[i];
            curr += (i - ps[i] - 1)*arr[i];
            curr += (ns[i] - i  - 1)*arr[i];
            res = Math.max(curr,res);
        }
        return res;

        
    }
}

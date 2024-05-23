import java.util.Stack;

public class LargestRectangularAreaEfficient {
    public static void main(String[] args) {
        int arr[] = {2,3,3,2};
        System.out.println(findLargestAreaRectangle(arr,arr.length));
    }
    static int  findLargestAreaRectangle(int arr[] , int n){
        Stack<Integer>s = new Stack<>();
        int res = 0;
        for(int i = 0;i<n;i++){
            int curr = 0;
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
               int  tp = s.pop();
               curr = arr[tp] * (s.isEmpty() ? i : i -s.peek()-1 );
               res = Math.max(res,curr);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int tp = s.pop();
            int  curr = arr[tp] * (s.isEmpty() ? n : n-s.peek()-1);
            res = Math.max(res, curr);
        }
        
        return res;
    }
}

import java.util.Stack;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int arr[]={12,1,0};
        findPreviousGreater(arr);
        System.out.println();
        findPreviousGreaterEfficient(arr);
    }
    static void findPreviousGreaterEfficient(int arr[])
    {
       int n = arr.length;
       Stack<Integer>s = new Stack<>();
       for(int i = 0;i<n;i++){
        while (!s.isEmpty() && arr[i] >= s.peek()) {
            s.pop();
        }
        int greateEle = s.isEmpty() ? -1 : s.peek();
        s.push(arr[i]);
        System.out.print(greateEle + " ");
       }
    }
    static void findPreviousGreater(int arr[]){
        int n = arr.length;
        
        System.out.print(-1 + " ");
        for(int i = 1;i<n;i++){
            int ans = -1;
            for(int j = i-1;j>=0;j--){
                if(arr[i] < arr[j]){ ans = arr[j];break;}
            }
            System.out.print(ans+" ");
        }
    }
}

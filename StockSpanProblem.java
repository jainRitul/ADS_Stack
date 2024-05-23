import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int arr[] = {30,20,25,28,27,29};
        int span[] = new int[arr.length];
        fillSpan(span,arr);
        for(int i=0;i<arr.length;i++)
        System.out.print(span[i] + " ");
        System.out.println();
        efficientStockSpan(arr);

    }
    static void efficientStockSpan(int arr[]){
        Stack<Integer>s = new Stack<>();
        s.push(0);
        System.out.println(1);
        for(int i=1;i<arr.length;i++){
             while(!s.isEmpty() && arr[s.peek()] < arr[i]){
                s.pop();
             }
             int span = s.isEmpty() ? i+1 : i - s.peek();
             System.out.println(span);
             s.push(i);
        }
    }
    static void fillSpan(int span[],int arr[]){
        int n = arr.length;
    
        for(int i=0;i<n;i++){
            int count  = 1;
            for(int j =i-1;j>=0&& arr[j]<=arr[i];j--)
             count++;
            
            span[i] = count;
        }
        
    }
}

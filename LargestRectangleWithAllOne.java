import java.util.Stack;

public class LargestRectangleWithAllOne {
    public static void main(String[] args) {
        int mat[][] = {{0,1,1,0},
                       {1,1,1,1},
                       {1,1,1,1},
                       {1,1,0,0}};

        System.out.println(sizeOfLargestMatWithAllOne(mat));                
    }
    static int largestHis(int arr[] , int n){
        int res = 0;
        Stack<Integer>s = new Stack<>();
        for(int i = 0;i<n;i++){

            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                int tp = s.pop();
                int curr = arr[tp] * (s.isEmpty()? i : i-s.peek()-1);
                res = Math.max(res,curr);
            }

            s.push(i);
        }
        while(!s.isEmpty()){
            int tp = s.pop();
            int curr = arr[tp] * (s.isEmpty() ? n : n-s.peek()-1);
            res = Math.max(res,curr);
        }
        return res;
    }
    static int sizeOfLargestMatWithAllOne(int mat[][]){
        int r = mat.length;
        int c = mat[0].length;

        int res = largestHis(mat[0] , c);

        for(int i  =1;i<r;i++){
            for(int j = 0;j<c;j++){
                if(mat[i][j] == 1){
                    mat[i][j] += mat[i-1][j];
                }
            }

            res = Math.max(res,largestHis(mat[i] , c));
        }
        return res;

    }
}

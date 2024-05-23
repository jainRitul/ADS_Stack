class LargestRectangularArea{
    public static void main(String[] args) {
        int arr[] = {2,5,1};

        System.out.println(largestRectangularArea(arr));
    }
    public static int largestRectangularArea(int arr[]){
        int n = arr.length;
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int curr = arr[i];

            for(int j=i+1;j<n;j++){
                if(arr[j] >= arr[i]){
                    curr+=arr[i];
                }else break;
            }
            for(int j=i-1;j>=0;j--){
                if(arr[j] >= arr[i]){
                    curr+=arr[i];
                }else break;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
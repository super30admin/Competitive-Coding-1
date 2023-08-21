// Time Complexity : O(n)
// Space Complexity : (1)

class MissingElement{
   public int findMissingNumber(int arr[]){
    int arr[] = new int[] {1,2,3,4,6,7};
        int n = arr.length;
        int out = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]-i > 1){
                out = i;
            }
        }
       System.out.print(out);
    }
}
// Time Complexity : O(n)
// Space Complexity : (1)

class MissingElement{
   public int findMissingNumber(int arr[]){
        int n = arr.length;
        int out = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]-i >1){
                out = nums[i-1];
            }
        }
        return out;
    }
}
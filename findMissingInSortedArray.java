// Time Complexity - O(logn) where n is the size of the input array
// Space Complexity - O(1)

class Solution{
    public int findMissingInSortedArray(int[] arr){
        int low = 0;
        int high = arr.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
          
            if(arr[mid] != mid+1){
                if(mid == low){
                    return low+1;
                }
                else{
                    high = mid-1;
                }
            }
            else{
                low = mid+1;
            }
        }
        
        return -1;
    }
}
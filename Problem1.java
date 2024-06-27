// Time Complexity : O(log n)
// Space Complexity : O(1)

// Any problem you faced while coding this : No

class Solution{
    public static int search( int arr[], int size ){
        if(arr == null || size == 0){
            return 0;
        }
        int low = 0;
        int high = size - 1;
        int mid = 0;
        while(high - low >= 2){
            mid = low + (high-low)/2;
            int midDiff = arr[mid] - mid;
            int lowDiff = arr[low] - low;
            int highDiff = arr[high] - high;

            if(mid != low){
                high = mid - 1;
            }else{
                low + mid + 1;
            }
        }

        return (arr[high] - arr[low] )/2  ;
    }
}

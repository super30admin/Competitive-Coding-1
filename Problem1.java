// Find the missing number in a sorted array
// Time complexity: O(log n)
// Space complexity: O(1)

class Solution {
    int missingNumber(int arr[]) {
        // code here
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] != mid +1){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low + 1;
    }
}

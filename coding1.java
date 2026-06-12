// Approach:
// Use binary search to compare each element with its expected value (index + 1).
// If the values match, the missing number lies in the right half; otherwise, it lies in the left half.
// Continue until the search space is exhausted and return the missing number.

// Time Complexity: O(log N)
// Space Complexity: O(1)

class Solution {
    int missingNumber(int arr[]) {
        // code here
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==mid+1){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low+1;
    }
}

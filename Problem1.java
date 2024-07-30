
// Time Complexity : O(log n)
// Space Complexity : 1
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach in three sentences only
// Calculate difference of element and the index at low,high, mid position
// If difference is not equal then element is missing at that side, ignore other side

class MissingNumber {
    public static int findMissingNumber(int arr[], int size)
    {
        int low = 0;
        int high = size - 1;
        int mid = 0;
        while(high-low >= 2){
            mid = low + (high - low)/2;
            int midDiff = arr[mid] - mid;
            int lowDiff = arr[low] - low;
            if (lowDiff != midDiff){
                high = mid;
            }
            else{
                low = mid;
            }
        }
        return (arr[low] + arr[high])/2;
    }
}
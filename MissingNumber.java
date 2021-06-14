// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class MissingNumber{
    public int missingNumber(int[] arr){
        int low = 0;
        int high = arr.length - 1;

        if(arr[0]!=1){
            return 1;
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == mid + 1){
                low = mid + 1;
            }
            else if(arr[mid] == mid + 2){
                high = mid - 1;
            }
        }
        return arr[low] - 1;
    }
}
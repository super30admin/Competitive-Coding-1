// Time Complexity : O(log n) as it's binary search.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not much, I was intially thinking of array.length/2 and checking with mid to see which side
// of the array to go ahead with. But later realized it wont work always and got a suggestion to use indexes. One I considered index, it
//was a straight forward binary search.

// Your code here along with comments explaining your approach


class Solution {
    int missingNumber(int arr[]) {
        // code here
        int low = 0;
        int high = arr.length - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == mid+1){ //right part from mid
                low = mid+1;
            }else{ //left part from mids
                high = mid-1;
            }
        }
        return low+1;
    }
}

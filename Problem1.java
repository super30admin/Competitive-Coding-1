/*
Author: Akhilesh Borgaonkar
Problem: Find missing element
Approach: Using binary search to find if the mid element is in sync with the index of the mid element. If not then size your next sub array to search accordingly.
Time Complexity: O(logn) where n is number of elements in the array.
Space complexity: O(1) constant
Verified.
*/

class Solution {
    public int missingNumber(int[] arr) {
        int low = 0, mid = 0;
        int high = arr.length;

        //Arrays.sort(arr);		//if arrays are not sorted then
        while(low < high){
            mid = low + (high-low)/2;
            if(arr[mid] > mid)		//checking if the mid index is in sync with the mid index if not then probably an element in the left is missing
                high = mid;
            else
                low = mid+1;		//else check in the right for missing element
        }
        return low;			
    }
}

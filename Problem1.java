
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    int missingNumber(int arr[]) {
        // code here
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == mid + 1){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return  left+1;
    }
}
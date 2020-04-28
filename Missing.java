/* Time Complexity : O(logn)-> Binary search
// Space Complexity : O(1) iterative
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was doing Binary search on both sides once we get the mid, and then was checking whether a
//                                           arr[mid] - mid >0 but then I realised what if the start value is 1. And Binary Search on both sides is = O(n)
/*Algorithm: Find the mid element. Compare the a[mid]- index(mid) with the start value and end value to see which side of the array is sorted.
It means the missing number is on the unsorted side. Hence, move the start and end pointer accordingly. Continue the same till the difference
between the element and index becomes unequal plus the end dominates the start by 1, return the avg between the two elements. 
*/
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        if(nums == null || nums.length == 0){return -1;}            //Base case
        return BinarySearch(nums, start, end);
    }
    private int BinarySearch(int[] nums, int start, int end){
        while(end - start > 1){
            int mid = (start)+(end-start)/2; 
            if(nums[mid]-mid == nums[start]-start){         // Check the indices difference between the number and its index
            start = mid
        } else {                            
            end = mid;                                              // Move the start and end pointer accordingly
        }
        }
        return (nums[start]+nums[mid])/2;                       // return the avg value between the numbers that is the missing number
}
}

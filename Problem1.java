// Problem: Find Missing Number in a sorted array
//[1,2,3,4,5,6,8,9]

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {

    public static void main(String []args){
        int[] nums = new int[]{1,2,3,5};
        int ret = missingNumber(nums);
        System.out.println(ret);
    }

    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low=0, high=nums.length-1;

        // Here the base case is to have atleast 2 elements in the array, later we can return the average of their values
        while (high-low >= 2) {
            int mid = low + (high-low)/2;

            // Check if the difference between the value and its index is same between mid and low, if not move high to mid
            if (nums[low]-low != nums[mid]-mid) {
                high = mid;
            }
            // Check if the difference between the value and its index is same between mid and high, if not move low to mid
            else if (nums[mid]-mid != nums[high]-high) {
                low = mid;
            }
        }
        return (nums[low]+nums[high])/2;
    }
}
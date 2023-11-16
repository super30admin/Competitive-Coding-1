// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

/*
LC - 268 https://leetcode.com/problems/missing-number/ Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.

Solution - Sort the array, Using Binary Search, find the half of the array with missing number, try to make halves
to point to the exact number.
 */

import java.util.Arrays;

class FIndMissingElement {
    public int missingNumber(int[] nums) {
        //ip = [3,4,6,7,8] [1,2,3,4, 5,6,8,9,10]
        Arrays.sort(nums);

        if(nums == null || nums.length == 0) return -1;

        if(nums.length == 1) return -1;

        int low = 0, high = nums.length -1, mid;

        while(low <= high) {
            mid = low + (high - low)/2;


            if(nums[mid] - nums[low] ==2)
                return nums[mid] -1;
            else if(nums[high] - nums[mid] ==2)
                return nums[mid] + 1;

            //Check the number of values tally with indexes
            if((mid - low) != (nums[mid] - nums[low]))
                high = mid -1 ;
            else
                low = mid + 1;

        }
        return -1;
    }

    public static void main(String args[]) {
        FIndMissingElement e = new FIndMissingElement();
        int[] in = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println("Missing number is: " + e.missingNumber(in));
    }
}
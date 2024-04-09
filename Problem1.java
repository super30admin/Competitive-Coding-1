
// Time Complexity : O(log(n))
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : In interview yes. 

/*
 * In the interview: since there is no target (wrong assumption), i jumped to a different approach like
 *  FindSomething in infinte length array - Although i should have noted the array length is unknown to find the mind, not the target.
 * 
 * Right approach:
 * Binary search
 * find the mid and Infer the target is mid+1
 * if nums[mid]!= mid+1 -> i.e., the sort is already messed up so the missing value would be to the left side -> so right = mid-1
 * if nums[mid]== mid+1 -> i.e., the array is sorted till the mid value, so missing value would be on the right side -> so left = mid+1
 * 
 */

public class Problem1 {

    public int findTheMissing(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] != mid + 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }
}
//Problem 12: Find Missing Integer - https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
//Time Complexity: log(n)
//Space Complexity: O(1) -> no extra space is used, only using pointers

public class Solution {
    public static int findMissingInteger(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the difference between the element and its index is more than 1
            if (nums[mid] - mid > 1) {
                // edge case
                if (mid == 0 || nums[mid - 1] - (mid - 1) == 1) {
                    return nums[mid] - 1;
                }
                //search to the left half
                high = mid - 1;
            } else {
                //search on the right half
                low = mid + 1;
            }
        }

        //returning -1 if no missing number found
        return -1;
    }
}


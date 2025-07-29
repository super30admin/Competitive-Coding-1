// I used Binary Search to locate the point where the difference between nums[i] and i changes.
// Normally, nums[i] - i should be the same across the array (since numbers are consecutive).
// The missing number lies where this difference changes between two midpoints.

// Time Complexity : O(log n)
// Space Complexity : O(1)


public class Problem2 {
    static int missingNumSorted(int[] nums) {

        // Edge case: if the first element is not 1, missing number is 1
        if (nums[0] != 1) {
            return 1;
        }

        // Edge case: if the last element is not n, missing number is n
        if (nums[nums.length - 1] != nums.length + 1) {
            return nums.length + 1;
        }

        int low = 0, high = nums.length - 1;

        while ((high - low) > 1) {
            int mid = (low + high) / 2;

            // If difference between nums and indices changes before mid
            if ((nums[low] - low) != (nums[mid] - mid)) {
                high = mid;
            }
            // Else, the change lies after mid
            else if ((nums[high] - high) != (nums[mid] - mid)) {
                low = mid;
            }
        }

        // Missing number is between nums[low] and nums[high]
        return nums[low] + 1;
    }
}

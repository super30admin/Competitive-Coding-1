//Find the Missing Number in a sorted array

/*Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

        Examples:
        Input : arr[] = {1, 2, 3, 4, 5, 6, 8, 9}
        Output : 7

        Input : arr[] = {2, 3, 4, 5, 6, 7, 8, 9}
        Output : 1
*/

/**
 * <p>
 * Approach: We use binary search to efficiently locate the missing integer.
 * Since the array is sorted and contains consecutive integers starting from 1,
 * the missing number causes a misalignment where `nums[mid]` is not equal to `mid + 1`.
 * If `nums[mid]` is greater than `mid + 1`, the missing number is in the left half;
 * otherwise, it is in the right half. We continue adjusting the search space until we find the missing integer.
 * </p>
 * Time Complexity : O(log N)
 * Space Complexity: O(1)
 */

class MissingIntegerInSortedArray {

    private static int getMissingInteger(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] != mid + 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low + 1;
    }

    public static void main(String[] args) {
        // int[] nums = {1, 2, 3, 4, 5, 6, 8, 9};

        // int[] nums = {2, 3, 4, 5, 6, 7, 8, 9};

        int[] nums = {1, 3, 4, 5, 6, 7, 8};

        System.out.print("Missing integer is:" + getMissingInteger(nums));

    }
}

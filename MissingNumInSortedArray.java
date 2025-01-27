/**
 *
 * Find the missing number in a sorted array.
 * Given a list of n-1 integers, these integers are in the range
 * of 1 to n.
 * There are no duplicates in the list.
 * One of the integers is missing in the list. Write efficient code to find the missing integer.
 *
 */
public class MissingNumInSortedArray {
    public int missingNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        if (nums[low] != 1) {
            return 1;
        }

        if (nums[high] != nums.length + 1) {
            return nums.length + 1;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] - mid != nums[low] - low) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return nums[low] - 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4, 5};//Missing smallest number
        int[] nums2 = {1, 2, 3, 4};//Missing largest number
        int[] nums3 = {1, 2, 4, 5};//Missing a number in the middle
        int[] nums4 = {2};//Single-element array with missing 1
        int[] nums5 = {1};//Single-element array with missing nums.length + 1:
        int[] nums6 = {1, 2, 3, 5, 6, 7, 8};//Larger array with a missing number in the middle
        int[] nums7 = {};//Empty array
        int[] nums8 = null;//Null input
        int[] nums9 = {1, 2, 3, 4, 5};//no missing number
        MissingNumInSortedArray missingNumber = new MissingNumInSortedArray();
        System.out.println("Missing smallest number: " + missingNumber.missingNumber(nums1));
        System.out.println("Missing largest number: " + missingNumber.missingNumber(nums2));
        System.out.println("Missing a number in the middle: " + missingNumber.missingNumber(nums3));
        System.out.println("Single-element array with missing 1: " + missingNumber.missingNumber(nums4));
        System.out.println("Single-element array with missing nums.length + 1: " + missingNumber.missingNumber(nums5));
        System.out.println("Larger array with a missing number in the middle: " + missingNumber.missingNumber(nums6));
        System.out.println("Empty array: " + missingNumber.missingNumber(nums7));
        System.out.println("Null input: " + missingNumber.missingNumber(nums8));
        System.out.println("no missing number: " + missingNumber.missingNumber(nums9));
    }
}
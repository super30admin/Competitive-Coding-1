/**
 * Given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in list. One of the integers is missing in the list.
 * Write an efficient code to find the missing integer.
 * 
 * Input : arr[] = [1, 2, 3, 4, 6, 7, 8] Output : 5
 * 
 * Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9] Output : 7
 * 
 * Naive Approach: Linear scan of elements report when first element such that
 * it is not off by 1 than its index is found.
 * 
 * Space: Constant O(1)
 * Time: Linear O(N)
 * 
 * Optimized: Candidate for Binary Search as the array is sorted.
 * If mid meets this criterion: it is off by 2 from its index, and the previous one isn't, report it
 * otherwise, nums[mid] - mid == 1, --> missing on right side else left side
 * 
 * Space: Constant
 * Time: O(log n)
 */
public class Problem1 {

    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 5 };
        System.out.println("Missing: " + findMissingNumber(nums));
    }

    public static int findMissingNumber(int[] nums) {
        // base check: no elements
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // this element is off by 2, and the previous one isn't
            if (nums[mid] - mid == 2 && (mid == 0 || nums[mid - 1] - (mid - 1) == 1)) {
                return mid + 1;
            }
            // if this element is only off by 1, it means missing lies on right side
            if (nums[mid] - mid == 1) {
                low = mid + 1;
            } else { // on left
                high = mid - 1;
            }
        }
        // if there is no missing element
        return -1;
    }
}
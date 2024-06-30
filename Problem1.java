//find missing number in sorted array
 //Time Complexity: O(log N)
 //Space Complexity: O(1)
public class Solution {

    private int missing(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid + 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 5};
        System.out.println("Missing number is: " + solution.missing(nums1));
    }
}

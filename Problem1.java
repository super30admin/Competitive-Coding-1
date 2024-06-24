/*
Question --> https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
//Time Complexity --> O(logn)
//Space Complexity --> O(1)
 */

class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 5, 6};
        int res = findMissingNumber(nums);
        System.out.print(res);

    }

    public static int findMissingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] != mid + 1) {
                //go to left
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }//while
        if (nums[left] != left + 1) {
            return left + 1;
        } else {
            return nums[left] + 1;
        }

    }
}

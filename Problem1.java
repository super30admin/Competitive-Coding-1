//Problem - Find Missing Number in a sorted array
//Time Complexity - O(logn)
//Space Complexity - O(1)
/*Approach - If the index is equal to the number at that index, the missing number lies on the right side
Otherwise, the missing number lies on the left side */

class MissingNum {

    public int missingNumber(int[] nums) {

        int left = 0;
        int right = nums.length;

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

}
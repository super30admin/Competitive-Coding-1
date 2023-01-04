// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MissingNumber {

    public int search(int nums[]) {
        int low = 0;
        int high = nums.length - 1;
        int midvalue = low + (high - low) / 2;
        if (midvalue == 0) return midvalue + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((nums[mid] - mid) > 1 && nums[mid] - nums[mid - 1] > 1) {
                return mid + 1;
            } else if (nums[mid] - mid > 1 && nums[mid] - nums[mid - 1] == 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (midvalue + 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 5, 6, 7, 8, 9};
        MissingNumber s = new MissingNumber();
        int element = s.search(nums);
        System.out.println(element);
    }
}
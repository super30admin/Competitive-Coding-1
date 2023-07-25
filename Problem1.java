//Missing Number in sorted num array
class Problem1 {
    //TC: O(log n) SC: O(1)
    public int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (high - low >= 2) {
            mid = low + (high - low) / 2;
            int lowIndexDiff = nums[low] - low;
            int midIndexDiff = nums[mid] - mid;
            int highIndexDiff = nums[high] - high;
            if (lowIndexDiff != midIndexDiff) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return (nums[low] + nums[high]) / 2;
    }
}
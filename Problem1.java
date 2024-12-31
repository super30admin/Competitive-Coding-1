/**
 * Time Complexity: O(log N)
 * 
 * Space Complexity: O(1)
 */

class Problem1 {

  public int findMissingInSortedArray(int[] nums) {
    if (nums[0] != 1) {
      return 1;
    }
    if (nums[nums.length - 1] != (nums.length + 1)) {
      return nums.length + 1;
    }

    int low = 0;
    int high = nums.length - 1;
    while (high - low >= 2) {
      int mid = low + (high - low) / 2;
      int midIndxDifference = nums[mid] - mid;
      int lowIndxDifference = nums[low] - low;
      int highIndxDifference = nums[high] - high;
      if (midIndxDifference != lowIndxDifference) {
        high = mid;
      } else if (highIndxDifference != midIndxDifference) {
        low = mid;
      }

    }
    return (nums[low] + nums[high]) / 2;
  }
}
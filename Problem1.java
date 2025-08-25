// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// use binary search to find the minimum index where the number at index is not equals to index + 1
class Problem1 {
    public static int findMissing(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // since we have to find the minimum index, we have to keep discarding the right half till we find the minimum where the nums[mid] != mid + 1
            if (nums[mid] != mid + 1)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low + 1;
    }

    public static void main(String[] args) {
        System.out.println(findMissing(new int[]{1, 2, 3, 4, 6}));
        System.out.println(findMissing(new int[]{2, 3, 4, 5, 6}));
        System.out.println(findMissing(new int[]{2}));
        System.out.println(findMissing(new int[]{1, 2, 3, 4, 5}));
        System.out.println(findMissing(new int[]{1, 2, 4, 5, 6}));
    }
}
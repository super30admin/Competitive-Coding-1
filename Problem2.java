// Time Complexity :O(logn)
// Space Complexity :constant
// Did this code successfully run on Leetcode :NA
// Any problem you faced while coding this :No

public class Main {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 5, 6, 7 };

        System.out.println("Missing element" + findMissing(nums));
    }

    public static int findMissing(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;// checking edge cases
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;// calculate mid
            if (mid > 0) {// to prevent index=-1
                if ((nums[mid] - mid) == 2 && (nums[mid - 1] - (mid - 1) == 1))// if difference of index with element is
                                                                               // 2 while that of previous element is 1
                                                                               // return missing element
                {
                    return nums[mid] - 1;
                }
            }
            // else if difference is 1 that means, missing element is on right so shift
            // start to mid+1
            if ((nums[mid] - mid) == 1) {
                start = mid + 1;
            } else {// else shift to left by shifting end to mid-1
                end = mid - 1;
            }
        }
        return 0;
    }

}
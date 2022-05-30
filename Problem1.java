// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Question isn't available on leetcode, ran on geeks for geeks
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class Problem1 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 6, 7, 8 };

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((nums[mid] + 1 != nums[mid + 1]) || (nums[mid] - 1 != nums[mid - 1])) { // checking on either side of
                                                                                        // mid if the elements are not
                                                                                        // consecutive to find the
                                                                                        // missing element
                System.out.println(mid + 2);
                break;
            } else if (nums[mid] != mid + 1) { // if elements before mid are not consecutive, discard the ones after mid
                                               // cause the missing element will be between low and mid else on the side
                                               // after mid
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
}

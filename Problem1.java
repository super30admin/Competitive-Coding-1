/* Description: since we know that array is 1 to n consecutive numbers,so at any point if the element is not missing, 
element value eg.3 = index+1 bcoz we start from 0 eg.1+2 */
// Time Complexity : O(log n) - performing binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : premium
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
class MissingElement {
    public static int findMissingElement(int[] nums) {
        // Set the low and high value to start binary search
        int low = 0;
        int high = nums.length - 1;
        // When low is less than or equal to high, come out of the loop
        while (low <= high) {
            // Calculate the mid in below way to avoid integer overflow exception
            int mid = low + ((high - low) / 2);
            // Check if the elements till mid are proper by checking index+1
            // If it is true, that means left part all elements are present, move to right
            if (nums[mid] == mid + 1) {
                low = mid + 1;
            } else {
                // else move to left
                high = mid - 1;
            }
        }
        // low+1 will be the missing value once the loop is ended
        return low + 1;
    }

    public static void main(String[] a) {
        int[] nums = new int[] { 2, 3, 4, 5, 6 };
        System.out.println(findMissingElement(nums));

    }

}

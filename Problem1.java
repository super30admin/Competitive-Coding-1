// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : --
// Any problem you faced while coding this : yes, my while loop goes into infinite loop so I have dry run the code and understand the issue.

class Main {

    public static int missingElement(int[] nums) {

        // optimization if left most element is not 1 that means 1 is missing so we
        // return 1
        if (nums[0] != 1)
            return 1;

        // declare left pointer and right pointer
        int l = 0;
        int r = nums.length - 1;

        // here we traverse througth list by dividing the array by half we are going to
        // break the loop when right pointer is one index plus then left pointer
        while (l < r - 1) {

            // find the mid element
            int mid = l + (r - l) / 2;

            // if our mid element is equal to mid+1(index of mid +1) that means on the left
            // side there is no missing element so we discard left half
            if (nums[mid] == mid + 1) {
                l = mid;
            } else {
                // else we discard right half
                r = mid;
            }
        }

        // when while loop breaks our missing element is between left pointer and right
        // pointer so, we return left pointer element +1;
        return nums[l] + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 5, 6, 7, 8 };
        System.out.println("missing element is:" + missingElement(nums));
    }
}
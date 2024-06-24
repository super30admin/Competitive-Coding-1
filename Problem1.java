// Time Complexity : O(Logn) - Binary Search
// Space Complexity :O(1) - No extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Calculate the mid index and determine which side of the array has unequal numbers.
// Move towards the side with unequal numbers and check if the element before or after the mid index is missing.
// Repeat the process until the missing number is found.


public class Problem1 {
    public static void main(String[] args) {
        // Create an instance of Problem1
        Problem1 m1 = new Problem1();
        
        // Define an array of numbers with one missing element
        int[] nums = {20, 22, 24, 25};
        
        // Call searchMissing method and store the result
        int result = m1.searchMissing(nums);
        
        // Print the result
        System.out.println(result);
    }

    private int searchMissing(int[] nums) {
        int low = 0; // Initialize low index
        int high = nums.length - 1; // Initialize high index
        
        while (low <= high) {
            // Calculate the middle index
            int mid = low + (high - low) / 2;
            
            // Check if the left element is missing
            if (mid > 0 && nums[mid] - 1 != nums[mid - 1]) 
                return nums[mid] - 1;
            // Check if the right element is missing
            else if (mid < nums.length - 1 && nums[mid] + 1 != nums[mid + 1]) 
                return nums[mid] + 1;
            // Adjust the high index if the missing element is in the left half
            else if (nums[mid] - nums[low] != mid - low) {
                high = mid - 1;
            } 
            // Adjust the low index if the missing element is in the right half
            else {
                low = mid + 1;
            }
        }
        
        // Return -1 if no missing element is found
        return -1;
    }
}

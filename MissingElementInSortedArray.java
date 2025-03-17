//Find Missing Element in sorted array 

public class MissingElementInSortedArray {

    public int missingElementInSortedArray(int[] nums) {
        int n = nums.length; 
        int low = 0; 
        int high = n-1;

        while(low <= high) {
            int mid = low + (high-low) / 2;

           // Check for missing number before 'mid'
           if (mid > 0 && nums[mid] - nums[mid - 1] != 1) {
            return nums[mid] - 1;
            }
           // Check for missing number after 'mid'
           else if (mid < n - 1 && nums[mid + 1] - nums[mid] != 1) {
            return nums[mid] + 1;
            }
            // Move right if no gap found
            else if (nums[mid] == mid + 1) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1; // If no missing element is found
    }
}

// Time complexity : O(log n)

// Space Complexity : O(1)

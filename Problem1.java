// Time Complexity : O(logn) everytime we are reducing the search space by 1/2.
// Space Complexity : O(1) constant space complexity.
// Did this code successfully run on Leetcode : yes.
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
import java.io.*;

public class FindMissingNumber {
    
    public static int search(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        
        // Use binary search 
        while (low < high) {
            int mid = low + (high - low) / 2;  // we find mid of array
            int midIdx = nums[mid] - 1;        
            int lowIdx = nums[low] - 1;
            int highIdx = nums[high] - 1;  
            
            if (midIdx != lowIdx) { // we chech whether mid value and low value are equal or not
                high = mid-1;
            } else if (midIdx != highIdx) {  // we chech whether mid value and high value are equal or not
                low = mid + 1;   
            } 
        }
        
        return (nums[low]+nums[high])/2  // at last we get should add low value and high value divide by 2
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 6, 7, 8};
        System.out.println("Missing number: " + search(arr));
    }
}



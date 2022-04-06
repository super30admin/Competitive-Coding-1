// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : not found in leetcode
// Any problem you faced while coding this : no

import java.io.*;

class SearchMissingElement {
    
    public static int search(int[] nums, int size) {
        int low = 0, high = size - 1;
        
        while(low <= high) {
            
            int mid = low + (high - low) / 2;
            
            if(high - low == 1 && nums[high] - nums[low] > 1) {
                return nums[low] + 1;
            } else if(mid - low == nums[mid] - nums[low]) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return -1;
    }
	public static void main (String[] args) {
		int ar[] = {4, 5, 6, 8 };
        int size = ar.length;
        System.out.println("Missing number: " + search(ar, size));
	}
}
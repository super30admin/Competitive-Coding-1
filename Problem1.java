/*Time complexity - O(log(N)) - simce used a binary search approach
 *Space complexity - O(1)  - no auxiliary space occupied by this algorithm
 * */
import java.io.*;

class Main {
    
    public int findMissing(int[] nums){
        
        int lo = 0 ;
        int hi  = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            // check if indices correspond to the actual  contained element at that index
            if (nums[mid] == mid+1){
                // if index is consistent with its corresponding element.then continue moving right,  mid+1 since the array is starting with 1 and not zero 
                lo = mid+1;
            } else {
                // index is inconsistent with the elememt, there was an elemnt missing earlier, go to left
                hi = mid-1;
            }
            
        }
	// lo+1 since the number at any given location is its index +1 , by definition of the problem (had the array started with zero, 
	// return lo would have worked) 
        return lo+1;
    }
    
    
	public static void main (String[] args) {
		System.out.println("Found the first missing number in the given array ");
		// test case 1 int[] nums = new int[] {1,2,4,5,6,7,8,9};
		// test case 2 int[] nums = new int[] {1,2,3,4,5,6,8,9};
		// test case 3 
		int[] nums = new int[] {1,2,3,4,5,6,7, 8,9};
		Main mainObj = new Main();
		int missingNumber = mainObj.findMissing(nums);
		System.out.println(missingNumber);
	}
}

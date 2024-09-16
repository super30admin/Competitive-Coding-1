//Missing Element
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run  : Yes
// Any problem you faced while coding this : Took a while in figuring out the while condition


// Your code here along with comments explaining your approach
/*
 * The difference between the number and its corresponding index is of 1 considering the input array to start from 1. 
 * In case the input starts at any random number, we can use an offset variable to scale the input in 1..n range.
 */


class MissingElement {
    public int searchElement(int[] nums) {
        int low = 0, high = nums.length-1;
        int mid = 0, offset = nums[low];
        while(low+1 < high) {
            mid = low +(high-low)/2;
            // offset is used to scale the inputs from 1 to n, even if they start with any random number
            if(nums[mid]-mid-offset == 0) { // {5,7,8,9} --> mid = 1, nums[low] - nums[mid]; should be equal to mid. 
            	//If this condition holds true, the missing element lies on the right hand side. 
                low = mid;
            }
            else { //otherwise, missing element lies on the left hand side
                high = mid;
            }
        }
        return nums[low]+1;
    }
    
    // Main function
    public static void main(String[] args) {
        MissingElement m = new MissingElement();
        int result = m.searchElement(new int[]{5,7,8,9,10,11});
        System.out.println("Missing element:"+result);
        result = m.searchElement(new int[]{1,2,3,4,5,7,8,9,10,11});
        System.out.println("Missing element:"+result);
    }
}

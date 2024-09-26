
// Time Complexity : O(Log(N)), where n is nums.length
// Space Complexity : O(log(N)) as well?
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, figuring out what the base case is i.e (diff>1) to end while loop and figuring out how to move the high and low pointers. 


public static int search(int[] nums){
    int low =0;
    int high = nums.length-1;
    int mid = 0;
    int diff = high-low;

    while(diff > 1){
        mid = (low+high)/2;
        if((nums[low] - low) != (nums[mid]-mid)){
            high = mid;
        }else if((nums[high]-high) != (nums[mid]-mid)){
            low = mid;
        }
        diff = high-low;
    }

    return nums[mid] + 1;
}

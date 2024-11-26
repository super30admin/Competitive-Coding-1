//Time Complexity: O(long).
//Space Complexity: O(1). 


import java.io.*;

class GFG {
	public static void main (String[] args) {
		System.out.println("GfG!");
		int[] nums = new int[]{1,2,3,4,6,7,8,9,10};
		int ans = search(nums);
		System.out.println(ans);
	}
	
	public static int search(int[] nums) {

            int low = 0;
            int high = nums.length-1;

            while(low <= high){
                int mid = (low + high)/2;

                if (nums[mid]-1 == nums[mid-1])
                {
                    return nums[mid]+1;
                }
                else if(nums[mid]+1 == nums[mid+1])
                    return nums[mid]-1;
                
                if(nums[mid]-1 != mid){
                    high = mid - 1;
                }
                else
                low = mid + 1;
            }
            return -1;    
        }
}

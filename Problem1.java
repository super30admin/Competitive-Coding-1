
//Finding the missing number in the series  1 to n
//time complexity : o(logn)


import java.io.*;

class MissigNumber{
    public static int SeachMissing(int[] nums){
        int left = 1;
        int right = nums.length;
        while(left <= right){
            int mid = (left) + (right - left)/2;
            if(nums[mid] == mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
        
    }
	public static void main (String[] args) {
	    int[] nums = {1,2,3,4,6,7,8};
	    SeachMissing(nums);
	    
		System.out.println("GfG!");
	}
}
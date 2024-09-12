//time complexity: O(log N)
//Space complexity: O(1)
//if given an array of consecutive elements with 1 missing value, find the missing value
import java.io.*;

class findValue{
    public static int missing(int[] nums, int size){
        //intialize low and high values
    	int low=0,high=size-1, mid =0;
    	//apply binary search
    	while(low<=high){
    	    //find the mid index
	        mid=low+(high-low)/2;
	        //check if the difference of mid index value and mid index is equal is 1st element in the array or not
	        if(nums[mid]-mid==nums[0]){
	            //if equal, then left array is sorted, then check if the difference of mid+1 and mid values is 1 or not
	            if(nums[mid+1]-nums[mid]==1){
	                //if 1, change the value of low index and repeat
	                low=mid+1;
	            }
	            else{
	                //then return the missing value
	                return nums[mid]+1;
	            }
	        }
	        else{
	            //if not equal, then assume right array is sorted, then check if the difference of mid and mid-1 values is 1 or not
	            if(nums[mid]-nums[mid-1]==1){
	                //if 1, change the value of high index and repeat
	                high=mid-1;
	            }
	            else{
	                //then return the missing value
	                return nums[mid]-1;
	            }
	        }
	    }
	    //if no value is missing, return -1
	    return -1;
    }
	public static void main(String[] args) {
	    //intialize an array
	    //int[] nums={5,6,8,9,10,11,12,13};
        int nums[]={1, 2, 3, 4, 6, 7, 8, 9};
        int size=nums.length;
	    System.out.println("missing number: "+ missing(nums,size));
	
	}
}
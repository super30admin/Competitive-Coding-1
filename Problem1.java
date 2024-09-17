// Time Complexity : O(LogN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : --
// Any problem you faced while coding this : No

public class Main {

    public static void main(String[] args) {			// Main function
	    int[] arr = {1,2,3,4,6,7,8};
	    int range = 8;
        System.out.println("Missing element is " + Missing(arr, range));
    }

    public static int Missing(int [] nums, int N){

        if (nums.length == 1){			// if the array has only 1 element
            if (nums[0] == N){
                return N-1;
            }
            else{
                return N;
            }
        }
        int low = 0;
        int high = nums.length - 1;			// initialize the pointer to low and high of the array

        while(low <= high){					// run the loop until it low is less than or equal to high
            int mid = low + (high - low)/2;		// calculating mid value

            if(nums[0] + mid == nums[mid]){			// if the value at 0th index + index of mid is equal to value at mid, increment the low to mid + 
                low = mid + 1;
            }else {
                high = mid - 1;					// else decrement the high to mid - 1
            }
        }

        if(nums[low - 1] == N) {// if the first element is missing, then compare the current value at (low - 1) index to range, if true, return first element of the specified range
            return nums[0] - 1;
        }
        if(nums.length == low){// if the last element is missing, then compare the index of low and length of the array, return low + 1
            return low + 1;
        }
        return nums[low] - 1;//if any of the element in the array are missing, return the element accordingly.
    }
}

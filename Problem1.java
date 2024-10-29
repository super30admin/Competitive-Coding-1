import java.util.*;

public class Problem1{
	public static int findMissingNumber(int nums[]){
		if (nums[0] != 1) return 1;
		int low = 0, high = nums.length-1;
		while(low <= high){
			if(high-low == 1){
				return (nums[high]+nums[low])/2;
			}
			int mid = low + (high-low)/2;
			int midDiff = nums[mid] - mid;
			int leftDiff = nums[low] - low;
			int rightDiff = nums[high] - high;
			if(midDiff != leftDiff){
				high = mid;
			}else if(midDiff != rightDiff){
				low = mid;
			}else{
				break;
			}
		}
		return nums[nums.length-1]+1;
	}

	public static void main(String args[]){
		int nums[] = {2,3,4};
		int nums1[] = {1,2,3,4,5,6,7,8};
		int nums2[] = {1,2,3,4,5,6,8};
		int nums3[] = {1,3,4,5,6,7,8};
		System.out.println(findMissingNumber(nums3));
	}
	
}

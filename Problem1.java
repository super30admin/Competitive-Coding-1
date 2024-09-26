//Time Complexity - O(log  n)
//Space Complexity - O(1)
//Steps:
//1. Use BS - find mid diff as number at mid - index of mid
//2. if this diff is 1, assuming numbers are from 1 to n with increment 1, 
//then reduce search space to right else  left.

package Super30;

public class CompetitiveCoding1 {

	public static void main(String[] args) {
		int[] nums = new int[]{2,3,4,5,6,7,8,9};
		System.out.println("Missing number is " + findMissingNumber(nums));
		
		int[] nums2 = new int[]{1,2,3,4,5,6,8,9};
		System.out.println("Missing number is " + findMissingNumber(nums2));

	}
	
	public static int findMissingNumber(int[] nums) {
		if(nums == null) return 1;
		
		int start = 0;
		int end = nums.length -1;
		int diff = 1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			int midDiff = nums[mid] - mid;
			
			if(midDiff != diff)
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		return end == -1 ? 1 : nums[end] + 1;
		
	}

}


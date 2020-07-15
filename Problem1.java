

public class Problem1 {

	//Given the corner elements will be never missing, so I have tested with elements from 2 to 7, the program works fine for those elements.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,2,3,4,5,6,8};
		System.out.println(missingElement(nums));
	}
	//Approach: 1. Here, am comparing every mid element with the left element alone, if left is not one lesser than the mid, 
	//then am returning the missing element as left element plus one. 
	// 2. if mid element does not have that property, the mid and its mid-1 elements are in good position, then i will check the index of mid with mid element, 
	//if those are not equal, then i go left, because element somewhere in left is missing.
	//3. or else i will search the right array.
	public static int missingElement(int[] nums)
	{
		int left =0, right = nums.length-1;
		while(left <= right)
		{
			int mid = left + (right-left)/2;
			if(mid == 0 || nums[mid-1]+1 != nums[mid])
			{
				return nums[mid-1]+1;
			}else if(nums[mid] != mid+1)
			{
				right = mid-1;
			}else
				left = mid +1;
		}
		return -1;
	}
}
//Time Complexity : O(log n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : 
//Any problem you faced while coding this :
// Time Complexity : O(log N) where N is length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : ran it on local editor as this is only available for leetcode premium
// Any problem you faced while coding this : not really

public class SearchMissing
{
	public int searchMissing(int[] nums) {
        
        //since the array is contigous, perform binary search to find the missing element
		int low = 0;
		int high = nums.length - 1;

		while(low <= high) {
			int mid = low + (high - low)/2;

            //base condition - if mid is not at 0th index and
            // if mid is greater than mid - 1 by more than one
            //then return mid - 1
			if (mid - 1 >= 0 && nums[mid - 1] != (nums[mid] - 1)) {
				return nums[mid] - 1;
			} else if (nums[mid] == nums[0] + mid) {
                //if number at middle is at correct location, means
                //left sub sequence is contigous, go right
				low = mid + 1;
			} else {
                //else go left
				high = mid - 1;
			}
		}

        //there are no missing elements in this increasing/contigous array
		return -1;
    }	
    
    public static void main(String[] args) {
            int[] nums = new int[]{11,12,13,14,15,17};
            SearchMissing solution = new SearchMissing();

            System.out.println(solution.searchMissing(nums));
    }
}
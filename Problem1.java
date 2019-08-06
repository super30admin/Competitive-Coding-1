public class Problem1 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 5, 6, 7, 9};
		System.out.println(findMissingNum(nums));
	}

	private static int findMissingNum(int[] nums) {
		int lo = 0, hi = nums.length-1;
		if(nums[0] == 2) return 1;
		// Loop terminating condition
		while(lo<hi) {
			//Condition when solution is found
			if(hi-lo==1) {
				return nums[hi]-1;
			} else {
				int mid = lo+(hi-lo)/2;
				if(diff(nums, mid) == 1) {
					lo = mid;
				} 
				if(diff(nums, mid) == 2) {
					hi = mid;
				}
			}
		}
		return -1;
	}
	
	//Returns difference between index and its element
	private static int diff(int[] nums, int i) {
		return nums[i]-i;
	}

}


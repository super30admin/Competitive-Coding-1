//Find the missing element in a sorted array of 1 to n using binary search


public class FindMissingElement {
	
	public static int findMissing(int[] nums) {
		int low = 0;
		int high = nums.length -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if(nums[mid] == mid+1) {
				low = mid+1;
				
			} else {
				if(mid == 0) return 1;
				high = mid-1;
			}
				
				
				
		} return nums[high]+1;
		
	}
	
	public static void main(String[] args) {
		System.out.println(findMissing(new int[] {1, 2, 3, 4, 6, 7, 8}));
		System.out.println(findMissing(new int[] {2, 3, 4, 5}));
		System.out.println(findMissing(new int[] {1, 3, 4, 5, 6, 7, 8}));
	}

}


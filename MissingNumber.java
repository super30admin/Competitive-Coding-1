public class MissingNumber {
	public int getMissingElement(int [] nums) {
		int low = 0;
		int high = nums.length-1;
		while(low<high) {
			int mid = low + (high-low)/2;
			if(nums[mid] - mid != nums[0]) {
				int lowValue = nums[low]-low;
				int highValue = nums[high]-high;
				if(lowValue!=nums[0]) {
					high = mid;
				} else {
					low = mid;
				}
			} else {
				low = mid;
			}
		}
		return nums[low]-1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 5, 6, 7, 8 };
		MissingNumber missingElement = new MissingNumber();
		System.out.println(missingElement.getMissingElement(arr));
	}
}
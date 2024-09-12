
public class MissingElementInSortedArray {

	 public static int searchMissing(int nums[]) {
		int left = 0, right = nums.length - 1, mid = 0;

		while((right - left) > 1) {
			
			 mid = left + (right - left) / 2; 
			 	
			 if(nums[mid] != mid + 1) {
				 
				 right = mid;
			 }else {
				 left = mid; // 6
			 }	
			 }
		return nums[mid]+1;
		}
		
	public static void main(String args[]) {
		int nums[] = {1, 2, 3, 4,5,6,7,9,10,11, 12};
		System.out.println(searchMissing(nums));
	} 
}

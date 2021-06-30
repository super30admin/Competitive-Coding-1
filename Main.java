public class Main
{
    
	public static void main(String[] args) {
	    int[] nums = {1,2,3,4,5,6,8,9};
		
		int low = 0;
		int high = nums.length -1;
		
		while(high - low >= 2) {
		    int mid = low + (high - low) / 2;
		    
		    if(nums[mid] - mid != nums[low] - low) {
		        high = mid;
		    } else if(nums[high] - high != nums[mid] - mid) {
		        low = mid;
		    } 
		}
		System.out.println((nums[low] + nums[high]) / 2);
	}
}
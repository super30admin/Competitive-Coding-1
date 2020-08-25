
//TC: O(logN) where N is number of element in arrays and O(N) since we are restricting our search space to half of the array using Binary Search
// SC: O(1) since we are not using extra space to store elements
// 2 3 4 5 6 8
// We are using a modified binary search, We will check if the middle element+1 is equal to next element(4+1==5), if this is not the case, we return 
// middle element+1 number since that is missing( this is our Base Case). Also, if our middle element is greater than middle index+1, then we are sure that
// one of the elements on left side is missing. So, we bring the right pointer to mid-1. if mid element is less than mid index+1, then we move the pointer 
// to the right of array.


public class find_missing {
// 1 2 3 4 5 6 8 
// 0 1 2 3 4 5 6
	public int search(int nums[]){
		int left = 0;
		int right = nums.length-1;
		
		while(left<right) {
			
			int mid = left + (right-left)/2;
			
			if(nums[mid]+1!=nums[mid+1])
				return nums[mid]+1;
			else if(nums[mid]>mid+1)
				right = mid-1;
			else 
				left = mid+1;
		}
		return -1;
		
	}
	public static void main(String[] args) {
		find_missing fm = new find_missing();
		int[] nums = {2, 4, 5, 6, 7};
		System.out.println("MIssing number: "+fm.search(nums));
	}
}

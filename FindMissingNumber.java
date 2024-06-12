// Time Complexity : O(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :

public class FindMissingNumber {
	public static int findMissingNumberInSortedArray(int[] item){
		int low = 0;
		int high = item.length-1;
		int mid = 0;
		while(low<=high){
			mid = low + (high-low)/2;
			if((item[low] - low) != (item[mid] - mid))
				high = mid;
			else if((item[high] - high) != (item[mid] - mid))
				low = mid;
		}
		
		return item[mid]+1;
	}
	
	public static void main(String[] args){
		int[] item = {1,2,4,5,6,7,8,9};
		System.out.println(findMissingNumberInSortedArray(item));
		
	}
}

// Time Complexity : O(log n) where n is array length
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Not on leetcode
// Any problem you faced while coding this : No

public class Problem1 {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,6,7,8,9,10,11,12,13}; //5 missing
		System.out.println(search(array));
	}
	
	public static int search(int[] array)
	{
		if(array.length==0) return -1;
		
		int low = 0;
		int high = array.length-1;
		if(low+1!=array[low]) return low+1;
		if(high+1==array[high]) return array[high]+1;
		
		while(low < high)
		{
			int mid = low + (high-low)/2;
			
			if(mid+1 != array[mid])
			{
				high = mid;
			}
			else
			{
				low = mid + 1;
			}
		}
			return low+1;
	}
}

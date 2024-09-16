
//Time complexity = O(log n)
//Space complexity = O(1)
//Approach: 
/**
 * We are applying binary search to find out the missing element as this will give us ans in less time.
 * we will put low = 0 and high as last element in array. and calculate middle. 
 * Then we will check if element at index mid is rightly placed or not (i.e  if nums[mid] - 1 == mid  as elements in array are form 1 to n)
 * If this condition is satisfactory then add elements before mid index are rightly placed so we have to check right side of mid
 * if above condition is not matching then element at mid is not placed correctly. 
 * So we will check if either index == 0 or element before mid is placed correctly. If yes, the missing element is mid + 1.
 * Else we make high = mid - 1.
 * We will keep doing this till low <= high
*/

public class Solution{
  
 public int missingNumber(int[] nums){
        int low = 0;
	int high = nums.length - 1;
	
	while(low <= high) {
	     	int mid = low + (high - low) / 2;
		
		if(nums[mid] == mid + 1) {
			low = mid + 1;
		}else {
			if(mid == 0 || nums[mid - 1] == mid) {
				return mid + 1;
			}else {
				high = mid - 1;
			}
		}
	}

	return -1;
   }
}
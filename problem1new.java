
/*Find a missing number in a sorted array with no duplicates.  Array has a size of n with numbers from 1 to n+1.
Examples:
 
Input : 1 3 4 5 6  1 2 3 4 6    5 7 8 9 10   9 10 11 12 14
Output : 2

Input  : 2 3 4 5 7 8 9 10
Output  : 6
*/
public class problem1new {

	static int findMissing(int[] nums) {
		
		int l = 0;
		int h = nums.length -1;
		int mid = 0;
		
		while (l<=h) {
			
			mid = l + (h-l)/2;
			
			if( ( mid == 0 || (mid-1>0 && (nums[mid] - nums[mid-1] != 1)) )   // code to find the missing , missing element will present next to mid (Left side)
				 ) {
				return nums[mid-1] +1;
				
			}
			else if (( mid == nums.length || ( mid+1<nums.length &&  (nums[mid+1] - nums[mid] != 1)) )) { // code to find the missing , missing element will present next to mid (Right side)
				return nums[mid+1] -1;
			}
			
//			if( ( mid>0 && nums[mid] == nums[mid -1] +1 )                   // Check the wrong part  of the array , where we found  sequence correct. actually we need 
																			// return which is missing. 
//					&& ( mid< h && nums[mid] == nums[mid +1] -1  )
//					) {
//				 
//				 if( (mid+2 < nums.length-1) && ((nums[mid+2] - nums[mid+1]) > 1 )) {
//					 return nums[mid+1]+1;
//				 }
//				 else if(((mid-2)>0) &&  ( (nums[mid-1] - nums[mid-2]) >1 )){
//					 return nums[mid-1]-1;
//				 }
//				
//			}
//			
			else if( (nums[mid] - mid )  <= nums[l] ) {  // traversing rhs
				
				l = mid+1;
				
			}else if((nums[mid] - mid )  > nums[l] ) {  // traversing left hand side
				h = mid-1;
			}
			
			
		}
		return -1;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int nums[] = {3,4,5,6,7,8,9, 11};
		
		int missing = findMissing(nums);
		
		
		
		
		System.out.println(" Missing Number : "+missing);
		
		
		
		
		
	}
	
}

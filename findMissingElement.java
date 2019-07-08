
/*Find a missing number in a sorted array with no duplicates.  Array has a size of n with numbers from 1 to n+1.
Examples:
Input : 1 3 4 5 6
Output : 2
Input  : 1 2 3 4 5 7 8 9 10
Output  : 6
*/

//time complexity: O(n) ->one for loop

class Solution
{

	//returns missing element(if found), else -1
	static int findMissing(int nums[])
	{
	int l = 0, r = nums.length - 1; 
    while (l <= r)  
    { 
        int mid = (l + r) / 2;
       
        //if((mid == 0) && nums[mid] != mid + 1)
        	//return (mid+1);
        
        //found the missing element
        
        if (nums[mid] != mid + 1 &&  
                nums[mid - 1] == mid) 
                return (mid + 1); 
          
        
        if (nums[mid] != mid + 1) 
            r = mid - 1; 
      
        else
            l = mid + 1; 
    } 
  
// if no element is missing 
return -1;
}
	
	public static void main(String args[])
	{
		int nums[] = {1,2,3,4,5,6,8,9};
		System.out.println(findMissing(nums));
	}
	
}

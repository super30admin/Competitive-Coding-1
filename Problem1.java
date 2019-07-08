/*Find a missing number in a sorted array with no duplicates.  Array has a size of n with numbers from 1 to n+1.
Examples:

Input : 1 3 4 5 6
Output : 2

Input  : 1 2 3 4 5 7 8 9 10
Output  : 6
*/

//time complexity: O(n) ->one for loop
//space complexity: O(n) ->one array to store the elements

import java.io.*;

class Solution
{

	//returns missing element(if found), else -1
	static int findMissing(int nums[])
	{
		int i=0;
		for(i=0;i<nums.length;i++)
		{
			if(nums[i]!=i+1) //check if the element of the array is equal to the value that should be present at that index
				break;
		}
		if(nums.length==i) //if all the values are present, return -1 -> implies no element missing
			return -1;
		return i+1;
	}
	
	public static void main(String args[])
	{
		int nums[] = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(findMissing(nums));
	}
	
}
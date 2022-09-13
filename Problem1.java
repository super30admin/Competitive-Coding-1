
//Method 1
//time - O(log n)
//Space : O(1)
private int findMissingElement(int[] nums) 
{
	if(nums.length ==0 || nums == null) return -1;
	if(nums[0] != 1) return 1;
	if(nums[nums.length-1] == nums.length) return nums.length +1;
	
	
	int  low =0, mid=0;
	int high = nums.length -1;	
	
	while(low <= high)
	{
		mid = low + (high -low ) /2;
		
		if(nums[mid] == mid+1)
		{
			// Move to right side -
			// missing on right side
			//check immediate neighbor not to skip on missing numbers
			
			if(nums[mid]  !=  nums[mid+1]-1)
				 return nums[mid]+1; //missing number
			 
				low = mid + 1;

		}
		else //mising on left side
		{
			//move left
			//missing number on left
			//check immediate left neighbor not to miss on missing number example[1,2,3,5,6]
			if(nums[mid-1]+1 != nums[mid])
				return nums[mid] -1;
			high = mid -1;
			
		}
		
	}
	return -1;
}


//Mathod 2
private int findMissingElement(int[] nums) 
{
	if(nums.length ==0 || nums == null) return -1;
	if(nums[0] != 1) return 1;
	if(nums[nums.length-1] == nums.length) return nums.length +1;
	
	
	int  low =0, mid=0;
	int high = nums.length -1;	
	
	while(low+1 != high)
	{
		mid = low + (high -low)/2;
		
		if(nums[mid] == mid+1)
			low = mid;
		
		else
			high = mid;
				
	}
	return nums[low] +1;
}
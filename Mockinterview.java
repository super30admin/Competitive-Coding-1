/*
Find the missing number in the sorted array of given length 

Time Complexity: O(log N), where N is the number of elements in the array 
Space Complexity: O(1) 

Solution: Using Binary Search, calculate mid, then check for the conditions if the missing number is either on the left or right side with help of indices m,l, and h. 
*/


static int search(int nums[], 
				int size) 
{ 
  
	int l = 0 ; 
  	int h = size - 1 ;
  
  while (l <= h) {
    int m = l + (h - l) / 2 ;
    
    if (m != 0 && m != size -1) {
      
      if (nums[m] != nums[m - 1] + 1)
      return (nums[m] - 1) ; 
      if (nums[m] != nums[m + 1] - 1)
        return (nums[m] + 1) ; 
    }
    
    if ((m - l) != (nums[m] - nums[l])) {
      h = m - 1 ; 
    } else if((h - m) != (nums[h] - nums[m])) {
      l = m + 1 ; 
    }
  }
    return -1 ; 
} 

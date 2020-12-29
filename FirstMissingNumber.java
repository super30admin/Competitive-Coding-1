// Time Complexity: O(logN) since it binary search is used
// Space Complexity: O(1) - no extra space is required

class Solution{
  public int getFirstMissingNumber(nt[] arr)
  {
    if ( arr == null || arr.length == 0 )
       return -1;
    
    int low = 0;
    int high = arr.length -1 ;
   
    while ( (high-low) >= 2)
    {
       int mid = low + (high-low)/2;
       if (arr[mid] - mid == arr[low] - low) // left side of mid is sorted
       {
           low = mid;
       }
       else  // Right side of mid is sorted
       { 
           high = mid;
       }
    }
   
    return (nums[low] + nums[high])/2;
  }
}


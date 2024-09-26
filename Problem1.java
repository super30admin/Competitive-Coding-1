/*
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

Examples:

Input : arr[] = [1, 2, 3, 5, 6, 7, 8]

Output : 4

Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
*/


//Problem-1
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Running on eclipse
// Any problem you faced while coding this : None

 
class Missing_Number {
    private static int missing(int[] nums)
    {
      int low = 0;
      int high = nums.length-1;
      
      while(low<=high)
      {
        int mid = low + (high - low) /2;
        if(nums[mid]!= mid+1) // if value is not equal to one more than index
          return mid+1; // missing value is one more than index
        else
          if(nums[mid] == mid + 1) // if the value is equal to one more than index i.e the left part has no missing values till now
            low = mid +1; // move to right part
        else
          high = mid-1; // else move to left part
      }
      return -1;
    }
    public static void main(String[] args) {
      
     // int[] arr = {1, 2, 3, 5, 6, 7, 8};
       int[] arr = {1, 2, 3, 4, 5, 7, 8};
      int res = missing(arr);
      System.out.println(res);
      
    }
  }
  

/*

Problem Statement : There is one number missing in a sorted array. The range of elements are 1 to N + 1 and size of array is N. Find the missing number.

Time Complexity : O(logn)
Space Complexity : O(1)
Method : BinarySearch

*/

public class MyClass {
    public static void main(String args[]) {
      
      int[] nums = {1, 2, 3, 5, 6, 7, 8};
      
      int result = binarySearch(0, nums.length - 1, nums);
      
      System.out.println("Missing number : " + result);
    }
    
    private static int binarySearch(int low, int high, int[] nums)
    {
        int mid;
        
        while(low <= high)
        {
            mid = low + (high - low) / 2;
            
            if(nums[low] - low == 1 && nums[mid] - mid == 1) low = mid + 1;
            
            else high = mid - 1;
        }
        
        return nums[low] - 1;
    }
}

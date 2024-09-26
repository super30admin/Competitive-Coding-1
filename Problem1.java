// Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

// Examples:

// Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
// Output : 4

// Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
// Output : 3

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class solution{
    public static int findMissing(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while((high - low) > 1){
            mid = (high + low)/2;
            if((nums[low] - low) != (nums[mid] - mid)){
                high = mid;
            }
            else if((nums[high] - high) != (nums[mid] - mid)){
                low = mid;
            }
        }
        return (nums[low]+1);
    }
}
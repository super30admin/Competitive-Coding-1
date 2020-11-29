/*
https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

Examples:
Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4

Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
Output : 3
*/
/*

def search(ar, size):
    if ar is None or len(ar) == 0:
        return -1
    low = 0
    high = len(ar) - 1
    
    while low <= high:
        mid = (low + high) // 2
        
        if ar[mid] == mid + 1:
            low = mid + 1
        else:
            high = mid - 1
            
    return low + 1
    
    
    

# Driver Code 
a = [] 
n = len(a) 
print("Missing number:", search(a, n))

*/

// Time Complexity : O(logn) where n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/a
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: I have used the logic that number should be equal to its index+1. If
// it not then there is a number missing
class Solution {
    public int search(int[] nums) {
        if(nums == null || nums.length == 0)
        return -1;

        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high){
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == mid+1)
                low = mid + 1;
            else
                high = mid - 1;
            
        }

        return low + 1 ;
        
    }
}
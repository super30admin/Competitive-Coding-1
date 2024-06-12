/**
 * Problem Statement:
 * Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

Examples:
Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4

Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
Output : 3
 */


// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * In this problem, we know that there is only one integer missing and integers are in range from 1 to N-1
 * we check the left half half and right half by comparing the number and its index.
 * If on either half from start to end, there is a difference, we proceed to that half.
 * Finally we will be left with two elements and we simply return arr[low] + 1 or arr[high] - 1;
**/


class Solution {
    public int missingNumber(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            
            if(arr[mid] - mid == arr[low] - low) {
                low = mid;
            } else if (arr[high] - high == arr[mid] - mid) {
                high = mid;
            }
        }
        
        return arr[low] + 1;
    }
}
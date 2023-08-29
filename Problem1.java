// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * 1. Find the mid element and check if mid element is equal to mid index + 1
 * 2. If yes, then missing element is in right side of array
 * 3. If no, then missing element is in left side of array
 * 4. Repeat the steps 1 to 3 until low <= high
 * 5. Return low + 1
 */

class Solution {
    public static int findMissingNumber(int[] arr) {
        int len = arr.length;
        int low = 0, high = len - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == mid + 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3 , 5, 6, 7, 8};
        System.out.println(findMissingNumber(arr));
    }
}


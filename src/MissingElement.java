/*
problem statement - Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n. There are no duplicates in the array. One of the integers is missing in the array. Find the missing integer.
Approach: Using binary search, calculate the mid and check if the mid is in the right place if yes the missing number would be in the right side of mid update low = mid+1 position if not missing would be the left half
Time Complexity - O(log n)
Space Complexity - O(1)
 */

public class MissingElement {
    public static int missingNumber(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
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
}

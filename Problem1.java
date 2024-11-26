/*
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list.
One of the integers is missing in the list. Write a code to find the missing integer.

Input: [1, 2, 3, 4, 6, 7, 8]
Output: 4

Approach: If element at index i, is not equal to (i+1), then the missing element is on the left of the search space
Otherwise, it's on the right
TC: O(log n)
SC: O(1)
*/

public class Problem1 {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 6, 7, 8};
        System.out.println("Missing number: " + findMissingNumber(arr));
    }

    private static int findMissingNumber(int[] arr) {
        int low = 0, high = arr.length - 1, mid = 0;

        while (low <= high) {
            mid = low + (high - low)/2;
            if (arr[mid] != (mid + 1)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low + 1;
    }
}

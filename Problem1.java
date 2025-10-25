// Given a sorted array arr[] of n-1 integers,
//  these integers are in the range of 1 to n. There are no duplicates in the array. One of the integers is missing in the array.
//  Find the missing integer.


class Solution {
    int missingNumber(int[] arr, int n) {
        int low = 0, high = n - 2; // since size = n-1

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Expected value at mid index = mid + 1
            if (arr[mid] == mid + 1)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low + 1; // the missing number
    }
}

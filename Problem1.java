
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes on geeksforgeeks
// Any problem you faced while coding this : no

// binary search is utilised. while loop calculates the middle index mid and checks the differences between the
// elements and their indices to determine the direction to move the pointers.


import java.io.*;

class MissingNumberFinder {
    static int findMissingNumber(int[] sortedArray, int size) {
        if (sortedArray[0] != 1) {
            return 1;
        }
        if (sortedArray[size - 1] != (size + 1)) {
            return size + 1;
        }

        int start = 0;
        int end = size - 1;
        int missing = 0;

        while ((end - start) > 1) {
            int mid = (start + end) / 2;

            if ((sortedArray[start] - start) != (sortedArray[mid] - mid)) {
                end = mid;
            } else if ((sortedArray[end] - end) != (sortedArray[mid] - mid)) {
                start = mid;
            }
        }

        missing = sortedArray[start] + 1;
        return missing;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 8};
        int size = sortedArray.length;

        int missingNumber = findMissingNumber(sortedArray, size);
        System.out.println("Missing number: " + missingNumber);
    }
}

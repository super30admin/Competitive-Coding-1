// Time Complexity : Olog(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No, premium question

// Any problem you faced while coding this : Yes, referred to solution in the video

// Your code here along with comments explaining your approach in three sentences only
/*
 * iF two elements that my base case, so missing number is average of this two numbers
 * Applied binary search, if mid Idx difference is not equal to left idx difference then shift left 
 * and vice versa
 */

// Java code to implement the approach


class MissingNumberSortedArray {

    private static int searchMissingNumber(int arr[], int size) {
        int low = 0;
        int high = size - 1;
        int mid = 0;

        while (high - low >= 2) {
            mid = low + (high - low) / 2;
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;

            if (midIdxDiff != lowIdxDiff) {
                high = mid; //left shift
            } else {
                low = mid; //right shift
            }
        }

        return (arr[low] + arr[high]) / 2;
    }

    public static void main (String [] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 8};
        int size = arr.length;
        System.out.println("Missing number: " + searchMissingNumber(arr, size));

        int arr1[] = {3, 5, 6, 7, 8};
        int size1 = arr1.length;
        System.out.println("Missing number: " + searchMissingNumber(arr1, size1));

        int arr2[] = {5, 7};
        int size2 = arr2.length;
        System.out.println("Missing number: " + searchMissingNumber(arr2, size2));
    }
}
/*
https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/

Provide an array of n-1 integers in the range of 1 to n with no duplicates in list,
One of the integers is missing in the list. Write a code to find the missing integer.

Examples:
Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4

Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
Output : 3
*/

public class Problem1 {

    public static int search(int arr[]) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int first = arr[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == (mid + first)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low + first;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 1, 3, 4, 5, 6, 7, 8, 9, 11 }));

    }
}

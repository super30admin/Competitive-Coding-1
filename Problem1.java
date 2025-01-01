// Approach: We can solve this problem efficiently using binary search. We compare the mid element with its neighbors. If the difference
// between mid element and its neighbor is > 1, the number between these two is the missing number. If not, we reduce the search space. If the
// difference between mid element and first element of current search space is equal to mid, we move to right of mid. otherwise we move left.
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;
class MissingNumberInSortedArray {
    int findMissingNumber1(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        // Handle edge cases first - check first and last element
        if (arr[0] != 1) {
            return 1;
        }
        if (arr[n - 1] != n + 1) {
            return n + 1;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && arr[mid] - arr[mid - 1] > 1) {
                return arr[mid] - 1;
            } else if (mid < n - 1 && arr[mid + 1] - arr[mid] > 1) {
                return arr[mid] + 1;
            }
            if (arr[mid] - arr[low] != mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    int findMissingNumber2(int[] arr) {
        int n = arr.length;
        // Handle edge cases first - check first and last element
        if (arr[0] != 1) {
            return 1;
        }
        if (arr[n-1] != n + 1) {
            return n + 1;
        }
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] != mid + 1) {
                if (mid > 0 && arr[mid - 1] == mid) {
                    return mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    int findMissingNumber3(int[] arr) {
        int arrSum = Arrays.stream(arr).sum();
        int n = arr.length + 1;
        int sumOfFirstN = (n * (n+1)) / 2;
        return sumOfFirstN - arrSum;
    }
    public static void main(String[] args) {
        MissingNumberInSortedArray mnisa = new MissingNumberInSortedArray();
        // Given a sorted list of numbers of size n-1 containing numbers from 1 to n with one number missing.
        // Find the missing number
        int[] arr = { 1, 2, 3, 4, 6, 7, 8 };
        // int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("Missing number is: " + mnisa.findMissingNumber1(arr));
    }
}

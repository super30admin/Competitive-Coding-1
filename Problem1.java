// https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
// Time Complexity : O(log n)
// Space Complexity : O(1)

// Binary search approach: calculate the mid index and check if the difference between 
// the value at mid and mid is same as the difference between low and low index. 
// If not, then the missing number is in the left half, else it is in the right half. 
// Repeat this process until we find the missing number. 
// the final answer will be the value at low index + 1.

class Main {
        static int missingNumber(int[] arr) {
        int n = arr.length;

        if (arr[0] != 1) {
            return 1;
        }
        if (arr[n - 1] != (n + 1)) {
            return n + 1;
        }

        int low = 0, high = n - 1;
        while (high - low > 1) {
            int mid = low + (high-low) / 2;
            if ((arr[low] - low) != (arr[mid] - mid)) {
                high = mid;
            } else if ((arr[high] - high) != (arr[mid] - mid)) {
                low = mid;
            }
        }
        return (arr[low] + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 8};
        System.out.println(missingNumber(arr));
    }
}
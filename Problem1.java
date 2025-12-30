//Missing Number in Sorted Array of Natural Numbers
// Solved it by binary search. intuition is that in an array of numbers starting from 1, the value at each index should be index + 1. If a number is missing, then this will become false. We find the mid and check if
// arr[mid] - 1 == mid. if it is false we move to the left half else the right half. 
//Time complexity is O(log n) and space complexity is O(1).
public class Problem1 {
    static int missingNumber(int arr[]) {
        // code here
        int n = arr.length;
        
        if (arr[0] != 1) {
            return 1;
        }
        
        if (arr[n - 1] != (n + 1)) {
            return n + 1;
        }
        
        int low = 0;
        int high = n -1;
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] - 1 != mid) {
                high = mid  - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return arr[low] - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        System.out.println(missingNumber(arr));
    }
}
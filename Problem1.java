//Find missing element in the sorted array
/*
time complexity: O(log n) 
Space Complexity: O(1)

Approach is applying binary search on the array elements checking if arr[mid] == mid + 1, if move the low pointer to mid + 1 and high = mid -1;
*/


public class MissingNumberSorted {
    
    public static int findMissing(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If element matches its expected 1-based position, search right
            if (arr[mid] == mid + 1) {
                low = mid + 1;
            } else {
                // Sequence already broke; search left to find the first mismatch
                high = mid - 1;
            }
        }

        // 'low' lands on the first index where arr[index] != index + 1
        return low + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 6, 7, 8};
        System.out.println("Missing: " + findMissing(arr1)); // Output: 4

        int[] arr2 = {2, 3, 4, 5}; // Missing the first number (1)
        System.out.println("Missing: " + findMissing(arr2)); // Output: 1

        int[] arr3 = {1, 2, 3, 4}; // Missing the last number (5)
        System.out.println("Missing: " + findMissing(arr3)); // Output: 5
    }
}

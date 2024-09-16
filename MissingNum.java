// Time Complexity : O(log(n)) where n = size of arr
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Did not find on Leetcode
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class Problem1 {

    public static int findMissingElement(int[] arr) {
        // Set lo and hi to start and end index of array
        int lo = 0;
        int hi = arr.length-1;
        while (lo < hi) {
            // Calculate mid index
            int mid = lo + (hi - lo) / 2;
            // If the element at the mid index of the array is at its correct place, search in the right part of the array
            if (arr[mid] == mid + 1) {
                lo = mid + 1;
            } else { // Else search in the left part inclusing the mid index
                hi = mid;
            }
        }
        // Return element at final low index - 1
        return arr[lo] - 1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 8};
        System.out.println("The missing element is: " + findMissingElement(arr));
    }
}
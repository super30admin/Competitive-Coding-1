//Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Apply binary search on the sorted array. Check if the left or right element of the mid is present or not. If not, return the
 * element. If Yes, check if the number of elements to the left of mid are equal to the difference of values at those indexes.
 * if not, then the left part has missing element, else right part has missing element
 */

public class Problem1 {
    public static int missingElement(int[] arr) {

        int low = 0, high = arr.length-1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if (low != mid && (arr[mid]-1) != arr[mid-1])
                return arr[mid]-1;
            else if(high != mid && (arr[mid]+1) != arr[mid+1])
                return arr[mid]+1;
            else if((mid-low) != (arr[mid]-arr[low]))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String args[]) {

        int[] arr = new int[]{2,3,4,5,6,7};
        int x = missingElement(arr);
        System.out.println(x);
    }
}


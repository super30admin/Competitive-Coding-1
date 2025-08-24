//Time Complexity: O(logn)
//Space Complexity: O(1)
//Approach: Check if the middle element == mid + 1 (which would mean that the left side does not have missing elements)
//in that case, search on the right side, else search on the right side
//finally, the while loop will end because low will cross over the high, and the output will be low + 1 or arr[low] - 1
class Solution {

    /**
     * Finds the missing number in the array using binary search
     *
     * @param arr the array
     * @return    the missing number in the array
     */
    public int missingNumber(int arr[]) {

        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == mid + 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low + 1;
    }
}

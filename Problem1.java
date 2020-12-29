
// TC = O(log n) where n is number of elements in array.
// SC = O(1) 


class Solution {
    public int missingElement(int[] arr) {
            if (arr == null || arr.length == 0) return -1;
            int low = 0, high = arr.length - 1, diff = arr[0];
            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                if (arr[mid] != mid + diff && mid > 0)
                {
                return mid + diff;
                }
                else if (arr[mid] == mid + diff && mid < arr.length)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
            return -1;      
    }
}

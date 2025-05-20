// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on GFG : Yes
// Any problem you faced while coding this : Needed to handle boundary conditions and off-by-one index checks

// Your code here along with comments explaining your approach in three sentences only:
// The array contains numbers from 1 to n+1 with one missing number in sorted order.
// I used binary search to find the missing number by checking for a gap of 2 between adjacent elements.
// If no gap is found, I adjusted the binary search based on expected vs actual values.

class Solution {
  public:
    int missingNumber(vector<int>& arr) {
        int n = arr.size();
        if (arr[0] != 1) return 1;          // Check if 1 is missing
        if (arr[n - 1] != n + 1) return n + 1; // Check if n+1 is missing

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            // Check if gap of 2 indicates the missing number
            if (arr[mid] - arr[mid - 1] == 2)
                return arr[mid] - 1;

            // Decide direction based on expected position
            else if (arr[mid - 1] == mid)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1; // If not found (shouldn't happen for valid input)
    }
};


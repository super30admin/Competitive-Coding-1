/*
 * Title: Find missing Number in a sorted array
 * Time Complexity : O(log(n))
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>

class Solution{
  public:
    int missingNumber(std::vector<int>& array, int n) {
        int L = 0;
        int H = array.size() - 1;

        sort(array.begin(), array.end());

        // if missing number is the first or last element
        if (array[0] != 1)
            return 1;
        else if (array[array.size() - 1] != n)
            return n;

        int M;
        while (L < H) {
            M = L + (H - L)/2;

            if (array[M] - array[L] != M - L) {
                H = M - 1;
            } else {
                L = M + 1;
            }
        }

        if (M > 0 && array[M] - array[M - 1] != 1)
            return array[M] - 1;
        else if (M + 1 < array.size() && array[M + 1] - array[M] != 1)
            return array[M] + 1;

        return -1; // no number missing
    }
};
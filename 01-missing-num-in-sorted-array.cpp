/*
TC - O(logN) for the binary search performed
SC - O(1)
Issues Faced - Yes, could not develop intuition for moving within binary search after getting the missing number count.
Now I understand that we wish to get to the closest point possible where missing number count is lt/eq to k, and from that point on we can extrapolate the missing numbers in constant time. The advantage is that this beats a linear O(n) scan.

Run on leetcode - no, since I do not have premium access.

*/

class Solution {
    public:
        int missingElement(vector<int>& nums, int k) {

            int n = nums.size();
            int lo = 0;
            int hi = n - 1;

            while (lo <= hi) {
                int mid = (lo + (hi - lo)/2);
                int missingNumbers = nums[mid] - nums[0] - mid;
                if (missingNumbers >= k) { //equal to is important, move left to find that inflection point
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            
            //at the end of this, we would be at the index where the missing numbers are lesser than or equal to the given k
            int stillMissingAtHi = nums[hi] - nums[0] - hi;
            return nums[hi] + (k - stillMissingAtHi);
        }
    };
    
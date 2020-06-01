// Time Complexity : O(N) where N=Number of elements in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
public:
    int missingNumber(vector<int>& nums) {

        int sum =0;
        int n= nums.size();
        for(int i=0;i<n;i++)
        {
            sum = sum + nums[i];
        }

        int expectedSum = n *(n+1) / 2;
        return expectedSum - sum;

    }
};

// Time Complexity : O(log n)
 
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Sorted the numbers and started comparison with 
// the indices. If the index and array value are same then
// the search space is towards right. Once high and low becomes 
// equal return the ans


#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n = nums.size();
        int ans = n;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (high + low)/2;
            if(nums[mid] == mid){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
};

// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//Could not check all Leetcode conditions
//Worked only for this condition :-
//{1000,1001,1002,1003,1005,1006}


// Your code here along with comments explaining your approach
//CODE IN C++//
class Solution {
public:
    int missingNumber(vector<int>& nums) {
    int i;
    for(i=0;i<nums.size();)
    {
        if(++nums[i]==nums[i+1])
           i++;
        else 
            break; //break out of loop when number not found in successive order
        
    }
    return nums[i];//return the missing integer
    }
};
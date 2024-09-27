//Given a list of n-1 integers and these integers are in the range of 1 to n. 
//There are no duplicates in list. One of the integers is missing in the list. 
//Write an efficient code to find the missing integer.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Solution with O(n) complexity

class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        int n=nums.length;
        int actual_sum=(n*(n+1))/2;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        
        int missing_no=actual_sum-sum;
        return missing_no;
    }
}
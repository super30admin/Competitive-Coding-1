// Time Complexity : O(n) for iterating over teh array to compute sum
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int missingNumber(int[] nums) {
        
        int sum=0;  
        int n=nums.length;
        int tot_sum=0;
 		for(int i=0;i<nums.length;i++){
     
     		sum=sum+nums[i];    // Calculate sum of values in the array
 		}   
        
        tot_sum=(n*(n+1))/2;    // Calculate sum of first n natural numbers using Gaussian formula
        
        return tot_sum-sum;   // Difference ebtween expected and sum obtained will return the missing number
        
    }
}
    

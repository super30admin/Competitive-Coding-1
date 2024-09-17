//Time Complexity : O(log N)
//Space Complexity : O(log N)
// did you try it on leetcode : yes, but time limit exceeded.

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return 0;
        return helper(coins , amount , 0 ,0);
    }
    private int helper(int[] coins , int amount , int index , int min)
    {
        //base case
        if(amount==0)
            return min;
        if(amount<0 || index >=coins.length)
            return -1;
        
        //choose
        int case1 = helper(coins, amount - coins[index],index,min+1);
        
        // don't choose
        int case2 = helper(coins, amount, index+1, min);
        
        if(case1 == -1)
            return case2;
        if(case2 == -1)
            return case1;
        
        return Math.min(case1,case2);
        
    }
}
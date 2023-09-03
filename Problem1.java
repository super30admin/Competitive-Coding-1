// Time Complexity : O(n) n is length of the input
// Space Complexity : O(n) - space for map
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Missing number in sorted array in range of 1 to n
//S30 FAANMG Problem #15 {Easy}


class Solution {

    public int missingNumber(int[] nums) {

        int n = nums.length;

        int[] hash = new int[n+1];

        for(int i=0; i<hash.length; i++)
            hash[i] = 0;

        for(int i=0; i<n; i++) {
            hash[nums[i]] = 1;
        }

        for(int i=0; i<hash.length; i++) {
            if(hash[i] == 0)
                return i;
        }

        return -1;
    }
}

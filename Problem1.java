// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //maintain map of num,index
        HashMap<Integer, Integer> map = new HashMap<>();
          
        
        for(int i=0; i<nums.length; i++) {
            //for every num, find rem= target - num
            int rem = target - nums[i];
            
            //if rem is present in map then return indices
            if(map.containsKey(rem)) {
               int[] ans= {i, map.get(rem)};
                
                return ans;
            } else {
                map.put(nums[i],i); // else add the num,index into map
            }
        }
        // else return list of -1
        return new int[]{-1,-1};
    }
}
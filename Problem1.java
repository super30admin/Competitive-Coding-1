// Time Complexity : O(n) because we traverse the array once and HashMap operations take O(1) on average
// Space Complexity : O(n) for storing numbers and their indices in the HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a HashMap to store each number along with its index as we iterate through the array.
// For every number, we calculate the required complement needed to reach the target and check whether it already exists in the map.
// If the complement exists, we return the stored index and current index as the required pair; otherwise, we store the current number and continue.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if (hashMap.containsKey(diff)) {
                return new int[] {hashMap.get(diff), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[] {};
    }
}

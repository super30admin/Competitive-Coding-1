
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // TC: O(n)
        // SC: O(1)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("Pairs not found");
    }
}
// Time - O(n)
// Spsce - O(n)
class Solution {
    // Store nums data and index in hashmap
    // then iterate over array again and do target - each value and look. in hashmap if we have it
    public int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> map = new HashMap();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }

        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff) && map.get(diff) !=i){
                return new int [] {i, map.get(diff)};
            }
        }
        return new int [] {-1,-1};
    }
}
O(N) time
O(1) space

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i:nums){
            if(nums[Math.abs(i)-1] < 0)
                continue;
            else
                nums[Math.abs(i)-1]*=-1;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            if(nums[i]>0)
                res.add(i+1);
        return res;
    }
}

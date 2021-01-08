class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        int output[] = new int[2];
        
        if(nums == null || nums.length <2) {
            
            output[0] = -1;
            output[1] = -1;
            
            return output; 
        }
        
        
        Map<Integer, Integer> hashMap = new HashMap<>();
        
        for (int i=0; i< nums.length; i++)
        {
            
            int current = nums[i];
            int difference = target - nums[i];
            
            if(hashMap.containsKey(difference))
            {
                output[0] = hashMap.get(difference);
                output[1] = i;
                
                return output;
            }
            
            hashMap.put(current, i);
            
            
        }
        
        output[0] = -1;
        output[1] = -1;
            
        return output; 

        
        
    }
}

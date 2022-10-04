//MissingNumber

//TimeComplexity O(n)
//SpaceComplexity O(1)

class Solution {
    public int missingNumber(int[] nums) {
        
        
        if(nums[0] != 0)return 0;
       
        if(nums[nums.length-1]- (nums.length-1) == 0)return nums.length;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i]-i != 0){
                return i;
            } 
        }
        return -1;
    }
}

//TimeComplexity logn
//SpaceComplexity O(1)

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        
        if(nums[0] != 0)return 0;
       
        if(nums[nums.length-1]- (nums.length-1) == 0)return nums.length;
        
        int low = 0;
        int high = nums.length-1;
        
        while(low < high){
            int mid = low + (high - low)/2;
            
            if(nums[mid]-mid == 1){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return high;
    }
}

class Solution {
    
    public int missingNumber(int[] nums) {
        // The idea is to XOR all the numbers, exisiting numbers become zero, the remaining number is the one which is missing
        int result = nums.length; 
        for(int i=0;i<nums.length;i++){
            result = result ^ i ^ nums[i];
        }
        return result;
    }
    
    public int missingNumberSumMethod(int[] nums) {
        int sum_arr = 0, sum_actual=0; 
        for(int i=0;i<nums.length;i++){
            sum_arr+=nums[i];
            sum_actual+=i;
        }
        sum_actual+=nums.length;
        return Math.abs(sum_actual-sum_arr);
    }
    
    public int missingNumberBF(int[] nums) {
        // Range of arr 0-nums.length
        boolean isLastElemPresent = false;
        for(int i=0;i<nums.length;i++){
            int elem = Math.abs(nums[i]);
            //System.out.println(" Elem "+elem+" i : "+i);            
            if(elem == nums.length){
                isLastElemPresent = true;
            }else{
                if(nums[elem]>0){
                    nums[elem]*=-1;
                    if(nums[elem]==0){
                        nums[elem] = -1;// since later if visited will be made negative
                    }
                }else{
                    // Reached last elemetn
                    if(i == (nums.length -1) && nums[i]==0){
                        nums[i] = 1;
                    }
                }
            }     
        }
        
        int zeroIdx = -1;
        if(isLastElemPresent){
            for(int i=0;i<nums.length;i++){
                int elem = nums[i];
                if(elem == 0){
                    zeroIdx = i;
                }
                //System.out.println(" Elem_ "+elem+" i : "+i);
                if(elem>0){
                    return i;
                }
            }
        }else{
            return nums.length;
        }
        
        return zeroIdx;
    }

    public static void main(String[] args) {
        System.out.println(" Program test ");
    }
}
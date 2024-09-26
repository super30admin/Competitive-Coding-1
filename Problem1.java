public int missingNumber(int[] nums) {

// Time Complexity : O(n log n)
// Space Complexity : O(1) n-> entries in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
        
    for(int i=0; i<nums.length; i++) {
        
        if(Math.abs(nums[i])==nums.length){
            
        }else
        {
        int x = Math.abs(nums[i]);
        nums[x] = nums[x]*(-1);
        }
       
    }
    
    boolean an = false;
    boolean last = false;
    int zero = 0;
    
    for(int i=0; i<nums.length; i++) {
        if(0==nums[i]) {
            an=true;
            zero=i;
        }
        if(Math.abs(nums[i])==nums.length) {
            last = true;
        }
        if(nums[i]>0) {
               return i;
        }
    }     
    //Exception Handling for [0,1]
          if(an && last) {return zero;}
           
          if(an){
              return nums.length;
          }else{
              return 0;
          }
   
}

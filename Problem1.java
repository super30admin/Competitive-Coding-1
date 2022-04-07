import java.util.Arrays;

class Problem1 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        
        if(nums[0] != 0){
            return 0;
        }
        if(nums[nums.length-1] != nums.length){
            return nums.length;
        }
        
        int low = 0;
        int high = nums.length -1;
        
        while(low <=high){
            
            int mid = low + (high - low)/2;
            
            if(mid==0 || nums[mid] - nums[mid-1] == 2){
               if(mid == 0){
                   return nums[mid]+1;
               }
                return nums[mid-1]+1;
            }
            
            if(nums[mid] == mid){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            
        }
        
        return 3424234;
    }

    public static void main(String args[]){
        Problem1 problem1 = new Problem1();

        System.out.println(problem1.missingNumber(new int[]{1,0,2,3,5}));
    }
}

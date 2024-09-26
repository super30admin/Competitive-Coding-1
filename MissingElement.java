public class MissingElement{



    private static int missingElement(int[] nums){
// Edge 


        int low = 0;
        int high = nums.length -1;
        int mid;
        while(low <= high){

            mid = low + (high - low)/ 2;
            if(nums[mid] - nums[mid - 1] != 1 & mid > 0){
                return nums[mid] - 1;
                }
            else if(nums[mid + 1] - nums[mid] != 1 & nums.length - 1 > mid) {
                return nums[mid] + 1;
            }
            
            if(nums[mid] - nums[low] != mid - low && mid > 0){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
            
            
    }   
        return -1;
    }

    public static   void main (String[] args){
        int nums[] =  new int[] {1,2,3,4,5,6,8};

        System.out.println(missingElement(nums));
    }



}
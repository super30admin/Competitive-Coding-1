public class MyClass {
    public static int returnMissingNum(int[] nums){
        int low=0; int high=nums.length-1;
        while(low<high){
             int mid=low+(high-low)/2;
             if(high == (low+1)){
                return nums[high] - 1;
            }
          
            if((nums[mid] - nums[low]) != (mid-low)){
                high = mid;
            }
            else if(nums[high]-nums[mid] != (high-mid)){
                low = mid;
            }
         
        }
        return -1;
    }
    public static void main(String args[]) {
        int[] nums = new int[]{6,7,8,9,10,11,13};
        int missing = returnMissingNum(nums);
        System.out.println(missing);
     
    }
}
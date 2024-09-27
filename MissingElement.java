
//Time Complexity: O(LogN)
//Space Complexity: O(1)


public class HelloWorld{

     public static void main(String []args){

        int[] nums = new int[]{1,3,4,5,6};
        
        int low = 0;
        int high = nums.length - 1;
        
        while(high - low >= 2){
            int mid = low + (high - low)/2;
            
            if(nums[mid] - mid > 1){
                high = mid;
            }else{
                low = mid;
            }
         
        }
        
    System.out.println("Result: "+((nums[low]+nums[high])/2));
 
     }
}

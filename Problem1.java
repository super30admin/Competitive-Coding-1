
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        
        int[] nums = {1,3,4,5,6,7};
        
        System.out.println(findMissingNumber(nums));
        
    }
    // Time - O(N), Space - O(1)
//     public static int findMissingNumber(int nums[]) {
//         if(nums.length == 0 || nums == null) {
//             return -1;
//         }
//         int sum = 0;
//         for(int i=0;i<nums.length;i++) {
//             sum += nums[i];
//         }
//         int n = nums.length + 1;
        
//         int actualSum = n * (n+1) / 2;
        
//         return actualSum - sum;
//     }

    // Time - O(lg N), Space - O(1)
     public static int findMissingNumber(int nums[]) {
        if(nums.length < 2 || nums == null) {
            return -1;
        }
       
        int low = 0, high = nums.length - 1;
        
        int mid = 0;
        
        while((high - low) >= 2) {
            mid = low + (high-low)/2;
            
            if((nums[mid] - mid) == (nums[low] - low)) {
                    low = mid;
            }
            else {
                    high = mid;                    
            }
        }
        return (nums[low] + nums[high]) / 2;
    }
      
}

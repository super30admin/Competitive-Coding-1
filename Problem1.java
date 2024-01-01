// // "static void main" must be defined in a public class.
// Time Complexity: O(log n)
// Space Complexity: O(1)
public class Problem1 {
    public static void main(String[] args) {
        int[] nums = {1,3};
        if(nums == null || nums.length == 0) return;
        int initialElement = nums[0];
        int num = missingElement(nums, initialElement);
        System.out.println("The missing number is: "+num);
    }
    
    public static int missingElement(int[] nums, int initialElement) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int n = nums.length ;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] != mid+initialElement && nums[mid-1] == mid+initialElement-1){
                return mid+initialElement;
            } else if (mid!=0 && nums[mid-1] != mid+initialElement-1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

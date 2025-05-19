// Time complexity - O(log n)
// O(1)
// Any problems while solving - No
// Using Binary serach to solve this, if nums[mid] == mid+1, we can ignore left part else we can ignore right part

class Main {
    public static int findMissingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == mid+1) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low+1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 7, 8};
        System.out.println(findMissingNumber(nums));
    }
}

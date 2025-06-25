// Time Complexity: O(log n)
// Space Complexity: O(1)
// Approach: Apply a binary search on the whole array. If value at mid index is not mid+1, then our target element exists on the left, else on the right. low+1 will be the missing element.
  
class GfG {

    public static int missingNumber(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        if (nums[0] != 1) return 1;
        
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] != mid+1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        System.out.println(missingNumber(arr));
        
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(missingNumber(arr));
        
        arr = new int[]{2, 3, 4, 5, 6, 7};
        System.out.println(missingNumber(arr));
        
        arr = new int[]{1};
        System.out.println(missingNumber(arr));
        
        arr = new int[]{2, 3};
        System.out.println(missingNumber(arr));
    }
}

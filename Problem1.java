class Problem1 { 

    public static void main(String[] args) {
        System.out.println(getMissing(new int[]{1, 2, 3, 4, 5, 7}));
    }

    /*
    Time complexity - O(log n)
    Space complexity - O(n)

    Approach:
    1. Since the array is sorted and starts with 1, check the difference between index and element at that index.
    2. Divide the array into halves, check the middle, if the above mentioned difference is greater than 2 then 
    the missing element resides on the left otherwise it's on the right.
    3. If the difference between the middle element and its previous element is greater than 1 then the missing 
    element is the middle number - 1.
     */

    public static int getMissing(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length-1;
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            if((nums[mid] - nums[mid-1]) > 1) {
                return nums[mid] - 1;
            }
            if((nums[mid] - mid) > 1) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
/*
Time Complexity : O(logn)  because we are divding n input everytime by half
Space Complexity : O(1)   nums array is inpit so does not count extra auxilary space.
*/
class Missing_Num {
    public int findnum(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            //check index with value of the number at index
            if (mid + 1 < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low + 1;
    }

    public static void main(String[] args) {
        Missing_Num mn_obj = new Missing_Num();
        int nums[] = {1, 2, 3, 4, 6, 7, 8};
        System.out.println("Missing number: " +
                mn_obj.findnum(nums));
    }
}
//Time Complexity: O(logn)
//Space Complexity: O(1)

class solution {
    static int findMissing(int nums[])
    {
        
        if (nums[0] != 1)
            return 1;
        if (nums[nums.length - 1] != (nums.length + 1))
            return nums.length + 1;
 
        int low = 0, high = nums.length - 1;
        int mid = 0;
        while ((high - low) > 1) {
            mid = (low + high) / 2;
            if ((nums[low] - low) != (nums[mid] - mid))
                high = mid;
            else if ((nums[high] - high) != (nums[mid] - mid))
                low = mid;
        }
        return (nums[low] + 1);
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int nums[] = { 1, 3, 4, 5, 6,7, 8 };
        System.out.println("Missing number: "
                           + findMissing(nums));
    }
}

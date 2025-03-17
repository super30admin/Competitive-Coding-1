class FindMissingNumber {
    public int missingNumber(int[] nums) 
    {
        if(nums.length == nums[nums.length-1])
        {
            return nums.length+1;
        }
        if(nums[0]!=1)
        {
            return 1;
        }
        int l = 0;
        int r = nums.length-1;
        while(r-l!=1)
        {
            int mid = l + (r-l)/2;
            int len = mid-l+1;
            int x = nums[mid] -nums[l]+1;
            if(len==x)
            {
                l = mid;
            }
            else
            {
                r = mid;
            }
        }
        int num = nums[l]+1;
        return num;
    }
    public static void main(String[] args) {
        FindMissingNumber miss = new FindMissingNumber();

        int[][] testCases = {
            {1, 2, 3, 5, 6, 7},   // Missing 4
            {2, 3, 4, 5},         // Missing 1
            {1, 2, 3, 4, 5},      // Missing 6
            {2},                  // Missing 1
            {1},                  // Missing 2
            {1, 2, 3, 4, 5, 6, 7}, // Missing 8
            {1, 2, 3, 4, 5, 6, 8, 9, 10}, // Missing 7
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15} // Missing 16
        };

        int[] expectedOutputs = {4, 1, 6, 1, 2, 8, 7, 16};

        for (int i = 0; i < testCases.length; i++) {
            int result = miss.missingNumber(testCases[i]);
            System.out.println("Output: " + result + ", Expected: " + expectedOutputs[i]);
        }
    }
}
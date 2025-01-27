// Time Complexity : O(log n)
// Space Complexity : O(1)

// Given a list of n-1 integers and these integers are in the range of 1 to n.
// There are no duplicates in list. One of the integers is missing in the list.
// Write an efficient code to find the missing integer.
class Problem1 {
    public int findMin(int[] nums)  {
        if(nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] - mid == 1){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return 1+low;
    }
}

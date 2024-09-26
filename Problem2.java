/**
 * Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
class Solution{
    /**
     * since the array starts from 1 to n and missing an ele, and the array starts from 0 indexed base.
     * using binary search, divide the array into 2 halves, if the mid ele is correctly placed, then move the low to mid+1
     * else if the mid ele is greater than what is expected in that place then move the high = mid
     * else low = mid as there might be a case where the mid ele is the missing ele.
     * @param nums
     * @return
     */
    public static int missingEle(int[] nums){
        if(nums == null || nums.length == 0)          // if the input is null or length 0 then return -1
            return -1;
        int low=0,high = nums.length-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(nums[mid] == mid+1) {                  // if the mid ele is correctly placed then move low to mid+1
                low = mid+1;
            }
            else if(nums[mid] > mid+1)                // if mid ele has elements > expected val : left side is not missing
                high = mid;                                 // move high = mid
            else                                      // its of no use
                low = mid;
        }
        if(nums[low] == low+1)                        // for edge case whn we get non missing array
            return ++nums[low];
        else
            return --nums[low];

    }
    public static void main(String[] args)
    {
        System.out.println(missingEle(new int[]{1,2,3,4,5,6}));
    }
}

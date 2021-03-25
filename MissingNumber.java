

package CompetitiveProgramming;
/*
 *  Time Complexity: O(log n) Since we are reducing the search are by half.
 *  Space Complexity: O(1) since we are not using any additional space.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  We perform binary search with the while condition as low<high since we would like to exit when the low and high reach the same index. This would be the index where the missing element was skipped.
 *  we compute the mid and if the value at mid is equal to mid index + 1 then the value is right so we set our low to mid+1 else we set the high to mid. When both low and high meet we exit out of the loop.
 *  The current low and high are equal and the index + 1 would be the missing element.
 */
public class MissingNumberSolution {

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3,4,5,6,8,9};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.getMissingNumber(nums));
    }
}
class MissingNumber{
    public int getMissingNumber(int[] nums){
        if(nums==null || nums.length==0) return -1;
        int low=0, high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]==mid+1){
                low=mid+1;
            }else high=mid;
        }
        return low+1;
    }
}


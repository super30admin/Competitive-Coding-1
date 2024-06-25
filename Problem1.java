// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

// Question: Find Missing Number from a Sorted Array.
class Solution {
  public int findMissing(int[] nums) {
    //Edge cases.
    if(nums.length == 0 || nums == null) return -1;

    int low = 0;
    int high = nums.length-1;

    while(low<=high) {
        int mid = low + (high-low)/2;
        //Check if element at mid is the one missing.
        if(nums[mid]!=mid+1) {
            //Check if the element before mid is not satisfying the condition as well.
            if(nums[mid-1]!=mid) {
                high = mid -1;
            }else {
                return mid+1;
            }
        }else {
            low = mid + 1;
        }
    }
    return low+1;
  }

  public static void main(String args[]) {
    int nums[] = {1,2,3,4,6,7,8,9};
    int result = findMissing(nums);
    System.out.println("Missing number: "+result);
  }
}
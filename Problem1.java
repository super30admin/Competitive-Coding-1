
// Find Missing Number in a sorted array of size n with one missing number
// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// thought process: at every step we're checking which part is sorted and then we're checking if the target lies in that part
// if it does, we're doing a binary search in that part, if it doesn't, we're doing a binary search in the other part
// we're doing this until we find the target or the low and high pointers cross each others
public class Problem1 {
public int findMissingNumber (int[] nums, int low , int high){
    if (nums.length == 0 || nums == null){
        return -1;
    }
    if (nums[0] != 1){
        return 1;
    }
    if (nums[high] != high +2){
        return high +2;
    }
    int mid =0;
    while (low <=high){
         mid =low + (high - low)/2;
        if (nums[mid] != mid+1 && nums[mid -1] == mid){
            return mid +1;
        }
        if (nums[mid] == mid +1){
            low = mid +1;
        } else {
            high = mid-1;
        }

    }
    return mid +1;
}
public static void main(String[] args){
    Problem1 problem1 = new Problem1();
    // int[] nums = {1,2,3,4,5,6,7,8};
    // int[] nums = {2,3,4,5,6,7,8,9};
    int[] nums = {1,2,4,5,6,7,8,9};
    // int[] nums = {1,3,4,5,6,7,8,9};
    // int[] nums = {1,2,3,4,5,7,8,9};

    System.out.println(problem1.findMissingNumber(nums, 0, nums.length-1));
}
}

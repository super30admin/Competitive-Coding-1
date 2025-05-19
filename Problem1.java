/*
 * Question : Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n.
 * There are no duplicates in the array.
 * One of the integers is missing in the array.
 * Write an efficient code to find the missing integer.
 * Input : arr[] = [1, 2, 3, 4, 6, 7, 8] Output : 5
 * Explanation: The missing integer in the above array is 5 
 * Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9] Output : 7
 * Explanation: The missing integer in the above array is 7 
 * 
 * Approach - The given array is in range of [1,n] where n = array length
 * The Brute-Force approach is to calculate estimated and actual sum and subtract the remaining is the
 * missing number.
 * Time Complexity - O(n) Space Complexity - O(1)
 * 
 * Optimized Approach - do a binary search as the given array is sorted, we find the mid index using
 * left and right pointer. mid = l + (r-l)/2. if nums[mid] == mid + 1 means that till mid the array is
 * correctly sorted and at each index i the element  = i+1, hence reject the left array and go to right.
 * else, reject the right array and go to the left.
*/

public class Problem1 {

    static int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == mid + 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l + 1;
    }

    public static void main(String[] args) {

        int[] nums_1 = { 1, 2, 3, 4, 6, 7, 8 };
        int[] nums_2 = { 1, 2, 3, 4, 5, 6, 8, 9 };
        System.out.println(missingNumber(nums_1));
        System.out.println(missingNumber(nums_2));
    }
}
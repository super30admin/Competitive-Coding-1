//leetcode - 268. Missing Number
/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 */
/*
 * Approach -1
 * Build another array, size n+1
 * go to the first array, what numer is available mark it in the another array,
 * at last run through the new array and return the value that's still -1
 * tc: O(n)
 * sc: O(n)
 */
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len + 1];
        Arrays.fill(arr, -1);

        for (int i = 0; i < len; i++) {
            arr[nums[i]] *= -1; // we can do this as it says all numbers are unique.
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                return i;
        }
        return 823783;
    }
}

/*
 * Approach -2
 * mathematicacl formula - total sum for n numbers = n* (n+1/2)
 * run for loop to find total sum, and subtracted result is the answer.
 * tc: O(n)
 * sc: O(1)
 */
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;

        int total = len * (len + 1) / 2;
        // System.out.println("total : "+total);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return total - sum;
    }
}

// approach -3
/**
 * sort the array
 * and find where the difference is >1 for consecutive values. that's the anwer
 * tc: O(n log n), sc: O(1)
 */
//Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers 
//is missing in the list. Write a code to find the missing integer.

// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. Store the elements in the set as set doesn't allow duplicates.
//2 Check if the set contains the elements from 1 to n.
//3 If it doesn't contain then return that element;

class MissingNumber {
    public int missingNumber(int[] arr) {
        // Hashset approach
        // Set<Integer> set = new HashSet<>();
        // int maxLength = nums.length + 1;

        // for (int a : nums) {
        // set.add(a);
        // }

        // for (int i = 1; i < maxLength; i++) {
        // if (!set.contains(i)) {
        // return i;
        // }
        // }
        // return -1;

        // binary search approach
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (high - low > 1) {
            mid = low + (high - low) / 2;
            int midIndex = arr[mid] - mid;
            int lowIndex = arr[low] - low;
            if (midIndex != lowIndex) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return (arr[low] + arr[high]) / 2;
    }

    public static void main(String arg[]) {
        MissingNumber obj = new MissingNumber();
        int arr[] = { 3, 4, 6, 7 };
        int miss = obj.missingNumber(arr);
        System.out.println("Missing number is = " + miss);
    }
}

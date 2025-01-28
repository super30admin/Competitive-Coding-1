// Time Complexity: O(log N)
// Space Complexity: O(1)

using System;

public class Solution {
    public static int Search(int[] nums, int size) {
        int low = 0, high = size - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the missing number is on the left side
            if (nums[mid] != mid + 1) {
                if (mid == 0 || nums[mid - 1] == mid) {
                    return mid + 1;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1; // No missing number found
    }

    static public void Main(string[] args) {
        int[] ar = { 1, 2, 3, 4, 5, 6, 8 };
        int size = ar.Length;
        Console.WriteLine("Missing number: " + Search(ar, size));
    }
}

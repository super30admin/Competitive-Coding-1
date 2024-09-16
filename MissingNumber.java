// Time Complexity: O(logn)
// Space Complexity : O(1) 

// Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, 
// One of the integers is missing in the list. Write a code to find the missing integer.
// Examples:
// Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
// Output : 4

// Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
// Output : 3

public class MissingNumber {

  public int missingNumber(int[] nums) {
    if (nums.length == 0) {
      return -1;
    }

    int start = 0, end = nums.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if ((nums[mid] != mid + 1) && (mid == 0 || nums[mid - 1] == mid)) {
        return mid + 1;
      }

      if (nums[mid] != mid + 1) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return start + 1;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 4, 5, 6 };

    MissingNumber mock = new MissingNumber();
    System.out.println(mock.missingNumber(nums));
  }
}
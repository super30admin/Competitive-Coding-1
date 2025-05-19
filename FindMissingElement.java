// TC: O(logn)
// SC : O(1)
// Approach : Brute force: Linear search - O(n) 
// Optimized - Binary Search - Find diffrence between element and index 
// nums[i] - i = 1 if all elements are present 
// nums[i] - i = 2 if there is some element missing so reject the other half 

public class FindMissingElement {

  public int missingElement(int[] nums) {

    int low = 0;
    int high = nums.length - 1;

    while ((high - low) > 1) {
      int mid = low + (high - low) / 2;

      if (nums[low] - low != nums[mid] - mid) {
        high = mid;
      } else if (nums[high] - high != nums[mid] - mid) {
        low = mid;
      }
    }
    return (nums[low] + 1);
  }

  public static void main(String[] args) {
    FindMissingElement obj = new FindMissingElement();
    int[] nums = new int[] { 10, 11, 12, 13, 15 };

    System.out.println(obj.missingElement(nums));
  }
}


class FindMissingElement {
  /**
   * https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
   * 
   * Time Complexity: O(log(n))
   * 
   * Space Complexity: O(1)
   */
  int findMissingElement(int[] nums){
    int left = 0, right = nums.length-1;

    while(left <= right){
      int mid = left + (right - left)/2;

      // if(nums[mid] - nums[mid-1] > 1){
      //   return mid;
      // }

      if(nums[mid] > mid+1){
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return nums[right] + 1;
  }
}

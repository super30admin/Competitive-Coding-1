// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : I provided num1 and num2 and tested on LeetCode Playgroud
// Any problem you faced while coding this : No

nums1 = [1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15];
nums2 = [1, 3, 4, 5, 6, 7, 8];

var findMissing = function (nums) {
  let low = 0;
  let high = nums.length - 1;
  while (low != high) {
    let mid = Math.floor(low + (high - low) / 2);
    if (nums[mid] > mid + 1) {
      high = mid;
    } else {
      low = mid + 1;
    }
  }
  return low + 1;
};

let result = findMissing(nums2);
console.log(result);

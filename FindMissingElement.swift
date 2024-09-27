Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

Examples:

Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4
//6,8,9,10,11,12,13 - Outpit 7

// Time Complexity : (O)logn
// Space Complexity : (O)1
// Did this code successfully run on Leetcode : not able to find this question in leecode 
/* Since array is sorted we can use binary search
 * find mid element and compare whether left element with mid is less than 1 
 * find mid element and compare whether right element with mid is grater than by 1 
 * If mid element nearby element is not the missing number then decide your low or high pointer
 * compare difference between (mid - low) and (nums[mid] - nums[low]) to decide your low or high pointer
 * 
 */



func findMissingElement(_ nums:[Int]) {
	//edge
	guard nums.count > 1 else { return -1 }
    var low = 0
    var high = nums.count - 1

    while low<=high {
      let mid = low + (high-low)/2
      if mid == 0 || nums[mid-1]+1 != nums[mid] {
       return nums[mid]-1
      } else if nums.count - 1 || nums[mid]+1 != nums[mid+1] {
       return nums[mid]+1
      }else (nums[mid] - nums[low]) == (mid - low) {
         low = mid + 1
      } else {
         high = mid - 1
      }
    }
	return -1
}
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach : find mid and check mid -start == mid_indx - start, if true search on second half else end = mid
// if mid and neighbours have difference more than 1 then we get the missing number


class Solution {

  public static int getMissing(int[] arr) {

    int s = 0;
    int e = arr.length - 1;
    while (s<e) {

      int mid = (s+e) /2;
      if(arr[mid - 1] != arr[mid]-1) {
        return arr[mid] -1;
      }

      if(arr[mid + 1] != arr[mid]+1) {
        return arr[mid] + 1;
      }

      if (arr[mid] - arr[s] != mid - s) {
        e = mid -1;
      } else if (arr[e] - arr[mid] != e - mid) {
         s = mid+1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,8};
    System.out.println(getMissing(arr));
  }

}

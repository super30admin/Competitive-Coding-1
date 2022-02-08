//Missing number
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Run a binary search technique to see if the differnces are of equal weghtage or not
//depending on this we can eliminate the part where the missing number doesn't exist.
class Solution {
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5, 6, 7, 8};
        System.out.println(search(arr));
    }

    public static int search(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while ((e - s) > 1) {
            int mid = s + (e - s) / 2;
            if ((arr[mid] - mid) != (arr[s] - s)) {
                e = mid;
            } else if ((arr[mid] - mid) != (arr[e] - e)) {
                s = mid;
            }
        }
        return (arr[s] + 1);
    }
}
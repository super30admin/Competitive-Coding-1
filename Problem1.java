// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, not a leetcode problem, but geeks for geeks
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using binary search to find the missing element
// Keep reducing the search space till we find the missing element

public class Main {
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,4,5,6,7,8};
        int result = search(arr);
        System.out.println(result);
        
    }
    
    private static int search(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] != mid + 1) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left + 1;
    }
}

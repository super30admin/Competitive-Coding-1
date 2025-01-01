// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only:
/*for an index i, the value at that index should be arr[i] = arr[0] + i
 if no elements were missing. The first index where the property arr[i] != arr[0] + i holds will help us identify the missing element*/
class MissingElementInSortedArray{
    public static int findMissingElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == mid + 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4,5, 6}; // Missing element is 4
        
        int missingElement = findMissingElement(arr);
        System.out.println("The missing element is: " + missingElement);
    }

}
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: find mid. we need to check element - index == 1 or not if yes then element is correctly placed in its place, so check left part like that with low and mid places and move to right or left part accordingly. low + 1 will be the missing element.

public class MissingElement {

    public static int getMissingElement(int[] input) {
        int low = 0, high = input.length - 1;
//        int missingIndex = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
//            if((input[mid] - mid == 2)) {
//                missingIndex = mid;
//            }
            if((input[low] - low == 1) && (input[mid] - mid == 1)) {
                //left contains all elements so skip this part
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
//        return missingIndex + 1;
        return low + 1;
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1,2,3,4,6,7};
        System.out.println("Missing Element in array: " + MissingElement.getMissingElement(input1));

        int[] input2 = new int[]{2,3,4,5,6,7,8,9};
        System.out.println("Missing Element in array: " + MissingElement.getMissingElement(input2));
    }
}



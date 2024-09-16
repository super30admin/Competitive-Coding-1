// Time Complexity : O(log(n)), 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package competitiveCoding1;

class Problem1 {

    public int missingNumber(int[] array, int size) {
        int l = 0, h = size - 1;
        while (h - l > 1) {
            int mid = l + (h - l) / 2;
            if (array[l] - l != array[mid] - mid) {
                h = mid;
            } else if (array[h] - h != array[mid] - mid) {
                l = mid;
            }
        }
        return array[l] + 1;
    }
}

// Driver code 
class Main {

    public static void main(String args[]) {
        int array[] = {1, 2, 3, 4, 5, 6, 8};
        Problem1 p1 = new Problem1();
        System.out.println("Missing number is : " + p1.missingNumber(array, array.length));
    }
}

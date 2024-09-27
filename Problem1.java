
/* https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
 * Time: O(logn)
 * Space: O(1)
 */
/*
Since the array is sorted, every value will have a relation with it's index.
Here, if a value is it's index+1, then the value is in the correct position.
*/
class Problem1 {

    public static int getMissing(int[] arr) {

        if (arr.length <= 0 || arr == null)
            return -1;

        int left = 0;
        int right = arr.length - 1;

        while (left < right && left != right - 1) { // terminating condition -> left and right finish in adjacent
                                                    // positions, return left+1 which is missing.

            int mid = left + (right - left) / 2;

            if (arr[mid] != mid + 1) { // missing number is in the left half
                right = mid;
            } else { // arr[mid] == mid + 1 so, left half is fine until mid, search in right half
                left = mid;
            }

        }

        return arr[left] + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 5, 6, 7, 8 }; // finally, arr[left]=3 and arr[right]=5
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20 };// finally, arr[left]=14 and
                                                                                           // arr[right]=16
        int[] arr3 = {};
        System.out.println(getMissing(arr2));
    }
}
/*
* Given a list of n-1 integers in the range of 1 to n. There are no duplicates in list.
* One of the integers is missing. Write an efficient algorithm to find the missing integer.
*/
class Solution {
    public static int findMissingNumber(int[] arr) {
        if (arr[0] != 1) return 1;
        int l = arr.length;
        if (arr[l-1] != l + 1) return l + 1;
        int low = 0;
        int high = l - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] - arr[mid - 1] > 1) {
                return arr[mid - 1] + 1;
            } else if(arr[mid + 1] - arr[mid] > 1) {
                return arr[mid] + 1;
            }
            if(arr[high] - arr[low] > high - low) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return l + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 6, 7, 8};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 8, 9};
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8};

        assert 5 == findMissingNumber(arr1);
        assert 7 == findMissingNumber(arr2);
        assert 9 == findMissingNumber(arr3);
    }
}

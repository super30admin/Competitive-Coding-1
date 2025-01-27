package problem1;

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : NO

// most efficient approach
//this approach can be used when the array from 1
// eg {1, 2,3, 4, 5, 7, 8}

class MissingElementApproach2
{
    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 5, 6, 7, 8};
//        int[] arr = {1, 2, 3, 4, 5, 6, 8};
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9};
//        int[] arr = {1, 3};
//        int[] arr = {2, 3};
//        int[] arr = {1, 2};
        int output = search(arr);

        System.out.println(output);
    }

    public static int search(int[] arr) {

        int n = arr.length;

        if(arr == null || arr.length == 0) return -1;

//        if (arr[0] != 1)
//            return 1;
//
//        if (arr[n - 1] != (n + 1))
//            return n + 1;

        int low = 0;
        int high = n - 1;

        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (arr[mid] - 1 != mid)
                high = mid;
            else
                low = mid + 1;
        }

        return low + 1;
    }
}

package problem1;

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : NO

// most efficient approach
//this approach can be used when the array does not start from 1
// eg {3, 4, 5, 7, 8}

class MissingElementApproach1
{
    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 5, 6, 7, 8};
//        int[] arr = {1, 2, 3, 4, 5, 6, 8};
//        int[] arr = {1, 2, 3, 4, 5, 7, 8};
//        int[] arr = {3, 4, 5, 7, 8};
        int[] arr = {1, 3};
        int output = search(arr);

        System.out.println(output);
    }

    public static int search(int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

//         this is the case where only 2 elements are left and the missing is between them
        while (high - low >= 2) {

            mid = low + (high - low) / 2;

            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;

//            checking on the left and then move to left
            if (midIdxDiff != lowIdxDiff) {
                high = mid;
            }
//            move to right
            else {
                low = mid;
            }
        }

        return (arr[low] + arr[high]) / 2;
    }
}

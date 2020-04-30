
/**
 * given an array of n-1 integers in the range of 1 to n with no duplicates in list,
 * One of the integers is missing in the list. Write a code to find the missing integer.
 * <p>
 * Examples:
 * Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
 * Output : 4
 * Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
 * Output : 3
 */
//Approach: it is not mentioned that array is sorted but we have given a constraint that elements will be from 1 to n
   // So using binary search here
public class MissingNumber {

    //Time complexity:o(log n)
    //Space complexity:o(1)
    public static int findMissingNumber(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 || (arr[mid] - arr[mid - 1] != 1)) {
                return arr[mid] - 1;
            }
            if (mid == arr.length - 1 || (arr[mid + 1] - arr[mid] != 1)) {
                return arr[mid] + 1;
            }
            if ((mid - left) != (arr[mid] - arr[left]))
                right = mid - 1;
            else if ((right - mid) != (arr[right] - arr[mid]))
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 6, 7, 8};
        System.out.println( findMissingNumber( arr ) );
    }
}

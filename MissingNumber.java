public class MissingNumber {
    public static void main(String args[]) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int missingnum = missingNum(arr);
        System.out.println(missingnum);
    }

    // TC: O(logn)
    // SC: O(1)
    private static int missingNum(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid == 0 || arr[mid] - 1 != arr[mid - 1])
                return arr[mid] - 1;
            if (mid == arr.length - 1 || arr[mid] + 1 != arr[mid + 1])
                return arr[mid] + 1;

            else if (mid - lo + 1 == arr[mid] - arr[lo] + 1)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
}
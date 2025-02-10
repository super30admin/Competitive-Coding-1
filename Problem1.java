// TC: O(logn)
// SC: O(1)

class Problem1 {
    private static int findMissingInteger(int arr[]) {
        if (arr == null || arr.length == 0)
            return -1;

        int n = arr.length;

        if (arr[0] != 1)
            return 1;

        if (arr[n - 1] == n)
            return n + 1;

        int l = 0;
        int h = n - 1;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] - mid - 1 >= 2)
                return -1;
            else if (mid + 1 != arr[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return arr[l] - 1;
    }

    public static void main(String args[]) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int ans = findMissingInteger(arr);
        System.out.println(ans);
    }
}
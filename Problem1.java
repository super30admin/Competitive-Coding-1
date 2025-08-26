class Solution {
    int missingNumber(int arr[]) {
        int l = 0;
        int h = arr.length-1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (arr[mid] == mid + 1) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return l + 1;
    }
}

class Problem1 {
    int missingNumber(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == mid + 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // left is the first index where arr[i] != i + 1
        return left + 1;
    }
}
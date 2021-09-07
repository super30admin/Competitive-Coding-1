class Problem1 {
    public int search(int arr[], int size) {
        int low = 0;
        int high = size - 1;
        int mid = 0;
        while (high - low >= 2) {
            mid = low - (high - low) / 2;
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;
            int highIdxDiff = arr[high] - high;
            if (midIdxDiff != lowIdxDiff) {
                high = mid;
            } else if (midIdxDiff != highIdxDiff) {
                low = mid;
            }
        }
        return (arr[low] + arr[high]) / 2;
    }
}

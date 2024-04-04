// Find the Missing Number in a sorted array

public static int missingNumber(int arr[]) {
    int low = 0;
    int high = arr.length - 1;

    while (low < high) {
        int mid = low + (high - low) / 2;

        if ((arr[mid] - mid) != (arr[0] - 0)) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }
    return arr[low] - 1;
}

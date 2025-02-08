// Find the missing number in a sorted array

//TC - O(logn)
//SC - O(1)


class Solution {
    public static int search(int[] arr, int size) {
        int low = 0;
        int high = size - 1;
        
        while (high - low >= 2) {
            int mid = 0;
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

public static void main(String[] args) {
    int arr[] = {1, 2, 3, 5, 6};
    int size = arr.length;
    System.out.println("Missing number:" + search(arr, size));
}
}

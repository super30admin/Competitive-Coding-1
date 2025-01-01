//TC: O(log n)
//SC: O(1) no extra space
//Approach: binary search,
// comparing at each mid if diff between low and mid is in sync with difference between each element should be
// if yes, go to right, else go left

class FindMissingNumber {
    public static int findMissingNumber(int[] arr) {
        int low = 0, high = arr.length - 1;
        int commonDifference = (arr[high] - arr[low]) / arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == arr[0] + mid * commonDifference) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[0] + low * commonDifference;
    }

}

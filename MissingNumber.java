//TC - O(log n)
//SC - O(1)

// To find missing number we compare the number with index. 
// we use binary search
public class MissingNumber {
    public static int missingNumber(int[] arr) {
    if (arr == null || arr.length == 0) {
        return -1;
    }

    // Special cases: 1 is missing or last element is missing
    if (arr[0] != 1) {
        return 1;
    }
    if (arr[arr.length - 1] != (arr.length + 1)) {
        return arr.length + 1;
    }    

    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] != mid + 1) {
            if (mid == 0 || arr[mid - 1] == mid) {
                return mid + 1;
            }
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return -1; // Shouldn't happen with valid input
    }
}

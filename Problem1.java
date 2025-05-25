/**
 * Approach:
 * - The array contains `n` elements from 1 to n+1 with one missing number.
 * - The elements are sorted and strictly increasing by 1 (except where the number is missing).
 * - First, check two edge cases:
 *   - If first element is not 1 → missing number is 1.
 *   - If last element is not n+1 → missing number is n+1.
 * - Otherwise, use binary search:
 *   - At any index `i`, the value should be `i + 1`. So, `arr[i] - i` should be constant.
 *   - If the difference `arr[lo] - lo` != `arr[mid] - mid`, the missing number is in the left half.
 *   - Else, it's in the right half.
 * - When `hi - lo == 1`, the missing number is between `arr[lo]` and `arr[hi]`.
 *
 * Time Complexity: O(log N), where N is the length of the array.
 * Space Complexity: O(1), constant extra space.
 */

public static int missingNumber(int[] arr) {
    int n = arr.length;
    // Edge case: missing number is 1
    if (arr[0] != 1) {
        return 1;
    }
    // Edge case: missing number is the last one (n + 1)
    if (arr[n - 1] != (n + 1)) {
        return n + 1;
    }
    // Binary search to find the missing number
    int lo = 0, hi = n - 1;
    while ((hi - lo) > 1) {
        int mid = (lo + hi) / 2;
        // If difference mismatch on left half
        if ((arr[lo] - lo) != (arr[mid] - mid)) {
            hi = mid;
        }
        // Else difference mismatch is on the right half
        else if ((arr[hi] - hi) != (arr[mid] - mid)) {
            lo = mid;
        }
    }
    // Missing number is between arr[lo] and arr[hi]
    return arr[lo] + 1;
}

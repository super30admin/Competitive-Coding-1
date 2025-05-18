/*
 * Find first missing positive integer in a 0-indexed integer array of non-decreasing order
 * Constraints: array[i-1] != array[i]
 */

 //Brute force:
 public int missingIntBrute(int[] a){
        int idx = 0;
        while(a[idx] == (idx + 1)){
            idx++;
            continue;
        }
        return idx+1;
    }

//Binary search logic with O(log n) complexity

public static int missingIntBinary(int[] a) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == mid + 1) {
                // No missing on the left, move in right subarray
                low = mid + 1;
            } else {
                // Missing number is on the left subarray (or is mid itself)
                high = mid - 1;
            }
        }
        // At the end of loop, low is the index where the number is missing
        return low + 1;
    }

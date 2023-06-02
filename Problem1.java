// O(logn) time complexity
//0(1) space
// the solution ran on IDE

public int findMissingInteger(List<Integer> nums) {
    int left = 0;
    int right = nums.size();

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums.get(mid) > mid + 1) {
            // The missing number lies between indices left and mid
            right = mid;
        } else {
            // The missing number lies between indices mid+1 and right
            left = mid + 1;
        }
    }

    // At the end of the loop, left will point to the missing number
    return left + 1;
}


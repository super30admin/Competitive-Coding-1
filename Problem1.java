// Time Complexity : O(log N) [...where N: lenght of array] (Binary Search)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class GFG {
    static int search(int ar[], int size) {
        int left = 0;
        int right = ar.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            // Check if diff between value and it's index (between left and mid)
            if ((ar[left] - left) != (ar[mid] - mid)) {
                // Missing number lies in left, move left
                right = mid;
            } else {
                // Missing number lies in right, move right
                left = mid + 1;
            }
        }

        return left + 1;
    }

    public static void main(String[] args) {
        int ar[] = { 1, 2, 3, 4, 5, 7 };
        int size = ar.length;
        System.out.println("Missing number: " + search(ar, size));
    }
}
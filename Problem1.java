/*
    TC - O(logn)
    SC - O(1)
*/


class Solution {
    static int findMinElement(int arr[])
    {   
        int n = arr.length;
        if (arr[0] != 1)
            return 1;
        if (arr[n - 1] != (n + 1))
            return n + 1;

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] != mid + 1) {
                if (arr[mid - 1] == mid) {
                    return mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5};
        int foundIndex = findMinElement(arr);
        System.out.println("Missing number: " + foundIndex);
    }
}

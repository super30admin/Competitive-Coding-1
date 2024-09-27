//Missing Number

//time complexity: O(logn)
//space complexity: O(1)

//elements will be sorted from [1,n]


public class Problem1 {
    public int findMissingElement(int arr[]) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] - mid > 1)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low + 1;
    }

    public static void main(String args[]) {
        MissingNumber mn = new MissingNumber();
        int[] a = {1, 2, 3, 4, 5, 6, 8};
        System.out.println(mn.findMissingElement(a));

    }
}
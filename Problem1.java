class FindMissingElement {
    public int findMissing(int arr[]) {
        if (arr == null || arr.length == 0)
            return -1;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] != mid + 1) {
                if (mid == 0 || arr[mid - 1] == mid)
                    return mid + 1;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        FindMissingElement ob = new FindMissingElement();
        int arr[] = { 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(ob.findMissing(arr)); // Output: 8
    }
}
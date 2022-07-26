
public class MissingInteger {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(searchValue(arr));
    }

    public static int searchValue(int[] arr) {
        int low = 0;
        int high = arr.length -1;
        int mid = 0;
        while (low<= high) {
            mid = low + (high - low)/2;
            if (mid == arr[mid] -1 ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return mid + 1;
    }
}
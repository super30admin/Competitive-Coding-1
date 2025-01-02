import java.lang.reflect.Array;

//TC:O(logn)
//SC:O(1)
public class binarySearch {
    public static int binarySearch(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] - mid != 1) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return arr[low] - 1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(arr));
    }
}


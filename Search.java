package s30;

public class Search {
    public static int searchEle(int arr[]) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if ((arr[mid] - mid) != (arr[0] - 0)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return arr[low] - 1;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 3, 4, 5, 6, 7};
        int m = searchEle(arr1);
        System.out.println("The missing element is: " + m);
    }
}

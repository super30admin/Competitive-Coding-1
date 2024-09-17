public class MissingNumber {

    public static void main(String[] args) {
        int arr[] = new int[] {1,2, 3, 5, 6, 7, 8};
        int result = missingElement(arr);
        System.out.println(result);
    }

    public static int missingElement (int[] arr) {

        if(arr == null || arr.length == 0) {
            return -1;
        }

        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = high - (low + high ) / 2;

            if(arr[mid] - mid > 1) {
                high = mid;
            } else if (arr[mid] - mid == 1) {
                low = mid + 1;
            }
        }
        return arr[high] -1;

    }
}

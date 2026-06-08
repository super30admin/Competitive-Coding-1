
public class Problem1 {

    public static void main(String[] args) {

        //find 4 in array = [1,2,3,5,6,7] using binary search
        int[] arr = {1, 2, 3, 5, 6, 7};
        int target = 4;
        int result = binarySearch(arr, target);
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }

    }
    public return int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == mid +1){
                left = mid +1;
            } else {
                right = mid -1;
            }
        }

        return left + 1;
    }
}
    
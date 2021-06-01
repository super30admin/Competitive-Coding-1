package leetcode;

public class interview1 {

    public static int search(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int mid=0;

        while (low < high) {
            mid = low + (high - low) / 2;
            if ((arr[high]-arr[low])==2) {
                return arr[low] + 1;
            } else if ((arr[mid] - arr[low]) > (arr[high] - arr[mid])) {
                high = mid ;
            } else {
                low = mid ;
            }
        }
        return arr[low] + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2,4, 5, 6,7,8};
        int miss = search(arr);
        System.out.println(miss);
    }
}
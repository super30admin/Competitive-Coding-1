import java.io.*;
class solution {

    static int searrch(int[] arr, int size) {
        int L = 0, R = size - 1;
        int mid;

        while ((R - L) > 1) {
            mid = (L + R) / 2;
            if ((arr[L] - L) != (arr[mid] - mid)) {
                R = mid;
            } else if ((arr[R] - R) != (arr[mid] - mid)) {
                L = mid;
            }
        }

        return arr[L] + 1;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 8 };
        int size = arr.length;

        System.out.println("Missing number: " + search(arr, size));
    }
}

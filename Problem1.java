import java.util.Scanner;

public class JavaPrac {

    static int missingEl(int A[]) {
        int l = 0, h = A.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (A[mid] == mid + 1) {
                l = mid + 1; // Search right
            } else {
                h = mid - 1; // Search left
            }
        }

        return l + 1;
    }

    public static void main(String[] args) {
        int A[] = {1,3,4,5,6};
        System.out.println("Missing element is: " + missingEl(A));
    }
}







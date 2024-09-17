
public class MissingNumber {

    static int MissingNumber(int arr[]) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] - mid == 1) {
                l = mid + 1;

            } else {
                r = mid - 1;
            }

        }
        return l + 1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int arr[] = new int[] { 1, 2, 4, 5, 6, 7, 8, 9 };
        System.out.println(MissingNumber(arr));

    }

}

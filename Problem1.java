public class Main {
    public static int getMissingElement(int[] arr) {
        int S = 0;
        int E = arr.length - 1;
        if (arr[S] != 1) {
            return 1;
        } else {
            while (S < E - 1) {
                int mid = (S + E) / 2;
                if (arr[mid] - arr[S] != mid - S) {
                    E = mid;
                } else {
                    S = mid;
                }
            }
            return (arr[S] + arr[E]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(getMissingElement(arr));
    }
}

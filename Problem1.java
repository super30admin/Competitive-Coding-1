class Solution1 {
    static int search(int ar[], int size) {
        int low = 0;
        int high = size - 1;

        while ((high - low) >= 2) {
            int mid = low + (high - low) / 2;
            int midIdxDiff = ar[mid] - mid;
            int lowIdxDiff = ar[low] - low;
            int highIdxDiff = ar[high] - high;

            if (midIdxDiff != lowIdxDiff) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return (ar[low] + ar[high]) / 2;
    }

    public static void main(String[] args) {
        int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
        int size = ar.length;
        System.out.println("Missing number: " + search(ar, size));
    }
}

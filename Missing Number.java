class MissingNumber {
    public static void main(String[] args) {
        int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
        int size = ar.length;
        System.out.println("Missing number: " + search(ar, size));
    }

    static int search(int ar[], int size) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Check current mid element and the previous elemnet with mid value
            if (ar[mid] != mid + 1 && ar[mid - 1] == mid)
                return mid + 1;
            // If the middle element is not equal to midindex+1 we know the missing element
            // is in the left side
            if (ar[mid] != mid + 1) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return -1;
    }

}

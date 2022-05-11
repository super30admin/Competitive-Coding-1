
//Find Missing Number in a sorted array
class Problem1 {
    static int search(int arr[], int size) {
        int a = 0, b = size - 1;
        int mid = 0;
        while ((b - a) > 1) {
            mid = (a + b) / 2;
            if ((arr[a] - a) != (arr[mid] - mid))
                b = mid;
            else if ((arr[b] - b) != (arr[mid] - mid))
                a = mid;
        }
        return (arr[a] + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 8 };
        int size = arr.length;
        System.out.println(search(arr, size));
    }

}

// Find missing element for the sorted array having elements from 1 to n-1
// Time Complexity - O(log n)
// Space Complexity - O(1)

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,5,6};
        int size = arr.length;
        System.out.println("Missing Value : " + search(arr,size));
    }

    public static int search(int[] arr, int size){

        int low = 0;
        int mid = 0;
        int high = size-1;

        while (high-low >= 2) {
            mid = low + (high-low) / 2;

            int lowIndexDiff = arr[low] - low;
            int midIndexDiff = arr[mid] - mid;
            int highIndexDiff = arr[high] - high;

            if ( midIndexDiff != lowIndexDiff) {
                high = mid;
            }
            else if (midIndexDiff != highIndexDiff) {
                low = mid;
            }
        }

        return (arr[low] + arr[high] ) / 2;
    }

}

// Time complexity: O(log n) where n is the length of the array.
// Space complexity: O(1).
class MissinginSortedArray {

    private static int search(int[] arr, int size) {
        int low = 0;
        int high = arr.length;
        
        while((high - low) >= 2){
            int mid = low + (high - low) / 2;
            int middiff = arr[mid] - mid;
            int lowdiff = arr[low] - low;
            if(middiff != lowdiff) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        return (arr[low] + arr[high]) / 2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 8};
        int size = arr.length;
        System.out.println("Missing number: " + search(arr, size));
    }
}
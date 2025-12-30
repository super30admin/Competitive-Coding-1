// Find missing number in a Sorted Array of Natural Numbers

// Approach:
// Check the value at middle if it equals index + 1, it indicates all the numbers on the left are present
// and the missing number is on the right. Shift the search to right side. If the value at mid is greater
// than index + 1, it indicates there is a value less on the left side, so move the search to left size of array.
class BinarySearch{
    static int missingNumber(int[] arr) {
        int len = arr.length;

        int low = 0;
        int high = len-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == mid+1){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return low+1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8};
        System.out.println(missingNumber(arr));
    }
}
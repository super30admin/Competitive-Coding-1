// Program executed successfully in mock interview
// Time complexity - O(log n)
// Space complexity - constant - O(1)

public class missingElement {
    public static void main(String[] args){
        int arr[] = new int[] {1,2,4,5,6};
        System.out.println(searchMissing(arr));
    }
    public static int searchMissing(int[] arr){
        // Initialize low and high
        int low = 0;
        int high = arr.length - 1;

        // Start Binary Search
        while(low <= high){
            int mid = low + (high - low) / 2;
            if (mid + 1 < arr[mid]){
                // move left
                high = mid - 1;
            }
            else{
                // move right
                low = mid + 1;
            }
        }
        return (arr[high] + 1);
    }
}

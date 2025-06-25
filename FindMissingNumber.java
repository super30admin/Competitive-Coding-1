public class FindMissingNumber {

    public int findMissing(int[] arr) {
        if (arr == null) {
            return -1;
        }

        int n = arr.length;
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return arr[0] == 1 ? 2: 1;
        } 

        int low = 0;
        int high = n - 1;    

        while (low <= high) {
            int mid = low + (high - low) / 2;


            if (arr[mid] == mid + 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high < 0 ? 1: arr[high] + 1;
        
    }
    
    public static void main(String[] args) {
        FindMissingNumber findMissingNumber = new FindMissingNumber();
        int arr[] = new int[] {1, 2, 3, 5, 6, 7, 8};
        // int arr[] = new int[] {1, 2, 4, 5, 6, 7, 8, 9};
        // int arr[] = new int[] {1, 2, 3, 4};
        // int arr[] = new int[] {2, 3, 4};
        // int arr[] = new int[] {2};
        // int arr[] = new int[] {1};
        // int arr[] = new int[] {};
        
        System.out.println(findMissingNumber.findMissing(arr));
    }

}
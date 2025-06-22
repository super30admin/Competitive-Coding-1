// We need to find the missing element in a given array when the numbers are 1 to n.
// Time complexity - O(log n)
// Space complexity - O(1)

class searchMissingElement {
    // Returns index of x if it is present in arr[l.. r], else return -1
    int binarySearch(int arr[])
    {
      /
        if(arr == null || arr.length == 0){
            return -1;
        }
        int x;

        int low = 0;
        int high = arr.length - 1;
        int mid;


        while(low<=high){
            mid = low + (high - low) / 2; // Prevent Integer Overflow
            // If we found the missing element at mid
            if (arr[mid] - mid != 1){
               return arr[mid]-1;
            }
           // If element is missing in the end.
            if(arr[low] - low == arr[mid] - mid && arr[high] - high == arr[mid] - mid){
                return arr[high] + 1;
            }
           // Normal cases where we first check if first half is uniform 
            if(arr[low] - low == arr[mid] - mid){
                low = mid + 1;
               }
            // If left is not uniform, then by default, element is missing from the left half
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Driver method to test above
    public static void main(String args[])
    {
        searchMissingElement ob = new searchMissingElement();
        int arr[] = { 1, 2, 3, 4, 5, 7 };
        int result = ob.binarySearch(arr);
        System.out.println(result);

        int arr2[] = { 1, 2, 3, 4, 5, 6};
        result = ob.binarySearch(arr2);
        System.out.println(result);

    }
}

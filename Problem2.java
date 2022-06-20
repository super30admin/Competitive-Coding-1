// Time Complexity: O(log(N)), where N is the length of given array
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : yes
class MissingElement {
    static int search(int arr[], int size)
    {
        int low =0;
        int high = size - 1;
        while(high - low >= 2) {
            int mid  = low + (high - low)/2;
            int midIndxDiff = arr[mid] - mid;
            int lowIndxDiff = arr[low] - low;
            if(midIndxDiff != lowIndxDiff) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return (arr[low] + arr[high])/2;
    }
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 8 };
        int size = arr.length;
        System.out.println("Missing number: " + search(arr, size));
    }
}

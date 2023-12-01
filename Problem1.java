// Time Complexity: O(log n)
// Space Complexity: O(1)
class MissingNumber{

    private static int search(int[] arr, int size) {

        int low = 0;
        int high = size-1;
        while(high - low >= 2){
            int mid = low + (high - low)/2;
            if(arr[mid] - mid != arr[low] - low)
                high = mid;
            else
                low = mid;
        }
        return (arr[low] + arr[high])/2;

    }
    public static void main(String[] args) {
        int arr[] = {2,4,5,6,7,8};
        int size = arr.length;
        System.out.println("Missing Number: " + search(arr, size));
    }


}
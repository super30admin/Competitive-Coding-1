//Missing in a Sorted Array of Natural Numbers
//Time Complexity - O(log n)
//Space complexity - o(1)

//Your approach
/*

*/

class Main {
    public static int searchMissingElement(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if ((arr[mid]-mid) == 1) {
                //left subarray is sorted, missing element is in right subarray
                low = mid+1;
            } else {
                //right subarray is sorted missing element is in left subarray
                high = mid-1;
            }
        }
        return low + 1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8};
        int element = searchMissingElement(arr);
        System.out.println("Missing element is:" + element);
    }
}

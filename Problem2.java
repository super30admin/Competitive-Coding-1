// Missing element
// Time Complexity: O(logn)
// Space Complexity: O(1)
class Problem2{
    public static int search(int arr[], int size){
        int low = 0;
        int high = size -1;
        int mid = 0;
        while(high - low >= 2){
            mid = low + (high - low)/2;
            int midDiff = arr[mid] - mid;
            int lowDiff = arr[low] - low;
            int highDiff = arr[high] - high;
            if(midDiff != lowDiff){
                high = mid;
            }
            else if(midDiff != highDiff){
                low = mid;
            }
        }
        return (arr[low] + arr[high])/2;
    }

    public static void main (String[] args){
        int arr[] = {1,3,4,5,6,7,8};
        int size = arr.length;
        System.out.println(search(arr, size));
    }
}

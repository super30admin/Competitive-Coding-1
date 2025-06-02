//Problem: Find missing number in a sorted array
//Time Complexity: O(log n)
//Space Complexity: O(1)

class Solution{
    public static int search(int[] arr, int size){
        int low =0;
        int high = size-1;
        int mid = 0;

        while((high - low) > 1){
            mid = low + (high - low) / 2;
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;
            
            if(midIdxDiff != lowIdxDiff){
                high = mid;

            }else {
                low = mid;
            }
        }
        return (arr[low] + arr[high])/2;
    }
}
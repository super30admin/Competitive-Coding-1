// Time Complexity :  O(log n)
// Space Complexity : O(1)

class Problem1 {
    public static int missingNumber(int arr[]) {
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == mid+1){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
           
        }
        return arr[low]-1;
    }

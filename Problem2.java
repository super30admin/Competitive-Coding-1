class FindMissingNumberInSortedArray {
    public int search(int arr[] , int size){
        //null check
        if(arr == null || arr.length == 0)
            return 0;

        int low =0;
        int high = size -1;
        int mid = 0;

        while(high - low >=2){
            mid = low + (high -low )/2;
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;
            int highIdxDiff = arr[high] - high;

            if(midIdxDiff != lowIdxDiff){
                high = mid;
            }
            else low = mid;
        }
        return (arr[low] + arr[high])/2;
    }
    public static void main(String args[]){
        System.out.println("test");
    }
}

// Time Complexity : O(log n) n - length of given array
// Space Complexity :O(1)
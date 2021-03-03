class Problem1{

    // Time Complexity: O(log n)
    // Space Complexity: O(1)

    public static int missingNumber(int[] arr){
        if(arr == null || arr.length == 0)
            return 1;
        if(arr[0] > 1)
            return 1;
        if(arr[arr.length-1] == arr.length)
            return arr.length+1;

        int low = 0;
        int high = arr.length - 1;
        while((high-low) > 1){
            int mid = low + (high - low) / 2;
            if(arr[mid] > (mid+1))
                high = mid;
            else
                low = mid;
        }
        return arr[low]+1;
    }
}

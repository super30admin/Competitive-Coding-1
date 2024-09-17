Time:O(logn)
Space:O(1)

public int missingNumber(int[] nums) {
    int size=nums.length;
    int low=0,high=nums.length-1;
    while(high - low >= 2){
        int mid = low + (high-low)/2;
        int midDiff = arr[mid] - mid;
        int lowDiff = arr[low] - low;
        int highDiff = arr[high] - high;
        if(midDiff!=lowDiff){
            high=mid;
        }else{
           low=mid; 
        }
    }
    return(arr[low] +arr[high])/2;
}




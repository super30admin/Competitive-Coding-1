
class MissingNumberInSortedArray {
    int missingNumber(int arr[]) {
        // code here
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==mid+1){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low+1;
    }
}
//Find Missing Number in a sorted array.


class Solution {
    int missingNumber(int arr[]) {

        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid] == mid+1){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return low+1;

    }
}
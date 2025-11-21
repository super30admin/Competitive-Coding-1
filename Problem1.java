
class Solution {
    int missingNum(int arr[]) {
        Arrays.sort(arr);
        int high=arr.length-1;
        int low =0;
        int n=high+2;

        while(low<=high){
            int mid= low+(high-low)/2;

            if(arr[mid]==mid+1){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low+1;

    }
}
/*

Problem : Find the missing element in the sorted array

 Time Complexity : O(logn)
 Space Complexity : O(1)
 LeetCode : Yes
 Problem Faced : NA

 */


 class Solution{
    int missingNumber(int arr[], int n){

        int low =0;
        int high = arr.length  -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid + 1 == arr[mid]){
                low = mid + 1;
            }
            else{
                if(mid == 0 || arr[mid-1] == mid){
                    return mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return low + 1;
    }
 }
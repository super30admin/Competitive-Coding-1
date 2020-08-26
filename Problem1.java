// Time Complexity : O(log n)
// Space Complexity : (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution{

    public static int missingNumber(int arr[]){
        int n = arr.length;
        if(arr.length == 0 || arr[0]!=1)
            return 1;

        if(arr[n-1] != n+1){
            return n+1;
        }

        int lo = 0, hi = n-1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(mid==lo){
                return arr[mid] + 1;
            }
            if(mid - lo != arr[mid] - arr[lo]){
                hi = mid;
            }else{
                lo = mid;
            }
        }
        return -1;
    }
}


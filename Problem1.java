Time complexity:O(logn)
Space complexity:o(1)

class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {

        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        
        while(high-low>=2)
        {
           mid = low + (high-low)/2;
           int middiff = arr[mid]-mid;
           int leftdiff = arr[low]-low;
           int rightdiff = arr[high]-high;
           
           if(middiff != leftdiff)
           {
               high = mid;
           }
           else if(middiff != rightdiff)
           {
               low = mid;
           }
        }
        return (arr[high]+arr[low])/2;
    }
}
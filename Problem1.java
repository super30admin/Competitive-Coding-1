// TC O(logn)
//SC O(1)

class Solution {
    private int search(int arr[], int n)
    {
        int low=0;
        int high=n-1;
        int mid=0;
        while(high-low>=2)
        {
             mid=low+(high-low)/2;
            int midDiff=arr[mid]-mid;
            int lowdif=arr[low]-low;
            int hifgdif=arr[high]-high;
            if(midDiff!=lowdif)
            {
                high=mid;
            }
            else if( midDiff!=hifgdif)
            {
                low=mid;
            }
        }
        return (arr[low]+arr[high])/2;
    }


    int missingNumber(int n, int arr[]) {

        // Your Code Here
        return search(arr,n);
    }
}
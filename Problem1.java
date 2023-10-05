

class Problem1 {
    int arr[] = new int[]{1,2,3,4,5,6,8,9};


    int missingNumber(int arr[], int n) {
        // Your Code Here
        int low =0;
        int high = n-2;
        
        /* This solution handles the main statement of the problem but fails 
        at the edge cases where the starting of the array is not 1.
        In this approach I've compared the differences to 1  and used binary 
        search for the missing number*/
        
        // MARK:- My approach
        while(high-low>=2){
            int mid = low+(high-low)/2;

            if (arr[low]-low!=1 || arr[mid]-mid!=1) {
                high = mid ;
            } else if (arr[high]-high!=1){
                low = mid;
            }
        }
        /*This solution handles the edge case where the array doesn't start with 1.*/
        // MARK:- Given approach
        low =0;
        high = n-2;
        while(high-low>=2){
            int mid = low+(high-low)/2;
            int lowIdxDiff = arr[low]-low;
            int midIdxDiff = arr[mid]-mid;
            int highIdxDiff = arr[high]-high;
            if (lowIdxDiff!=midIdxDiff) {
                high = mid ;
            } else if (highIdxDiff!=midIdxDiff){
                low = mid;
            }
        }

        return (arr[low]+arr[high])/2;
    }
}

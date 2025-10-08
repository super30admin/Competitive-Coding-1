//Time Complexity: O(log n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Before the missing element: arr[i] == i+1
// After the missing index: arr[i] == i+2
// So the missing number is i+1 at the first index where this occurs.


class Problem1{
    int missingNumber(int arr[]){
        int low,high,mid;
        low=0;
        high = arr.length-1;
        while(low<=high){
            mid=low+(high-low)/2;
            if(arr[mid]==mid+1){
                low=mid+1;//missing element is in right side
            }
            else{
                high=mid-1;//missing element is in left side
            }
        }
        return low+1;
    }
}

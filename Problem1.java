
//Time complexity: O(log n)
//Space complexity: O(1)

// we use binary search to find the missing number 
//the idea is to find the point where the difference between the element and its index is not consistent
// based on this we eliminate half of the search space in each step

class Solution {
    int missingNumber(int arr[]) {
        
        int n=arr.length;

        //edge cases for first and last element missing
        if(arr[0]!=1) return 1;
        if(arr[n-1]!=n+1) return n+1;
        
        int low=0,high=arr.length-1;
        while(high-low>1){
            int mid=low+(high-low)/2;
            if(arr[low]-low==arr[mid]-mid)
                low=mid;
            else
                high=mid;
        }
        return arr[low]+1;
    }
}
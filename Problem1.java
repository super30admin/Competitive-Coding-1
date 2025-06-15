// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
/*
 If the array is sorted then it will have 1 in 0th index , 2 in first index and so on , so i'm checking for index+1 value in index
 if not present return i
*/
class Solution {
    int missingNumber(int arr[]) {
        // code here
        int n = arr.length;
        for(int i=0;i<n;i++){
            //check every element
            if(arr[i]!=i+1)
                return i+1;
        }
        return -1;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
/*Any problem you faced while coding this : take sum formual and curr_sum is sum of present array
subtract last element from curr_sum and subtract this from sum
*/

class Solution {
    int missingNumber(int arr[]) {
        int n=arr.length;
        //compute sum
        int sum = (n*(n+1))/2;
        int curr_sum=0;
        //compute the current sum
        for(int i=0;i<arr.length;i++){
            curr_sum+=arr[i];
        }
        //remove last element because it is extra in the array
        return sum-(curr_sum-arr[n-1]);
    }
}



// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
/*Any problem you faced while coding this : Yes, Initially I checked for mid if right  high=mid-1
checked for high only if high is not right i did low = mid+1
but in the case where mid and high are both right return -1
when arrary becomes sorted it returns -1 for [1,3,4]
*/

/*
checking mid and if mid element is in right place , then there is some number missing between low and mid.
do high=mid-1 else do low=mid+1
check low if already correct then return -1 else return low+1
*/
class Solution {
    int missingNumber(int arr[]) {
        int low =0,high=arr.length-1;
        int mid =low+(high-low)/2;
        while(low<=high){
            mid =low+(high-low)/2;
            // number missing in first half
            if(arr[mid]!=mid+1){
                high=mid-1;
            }
            //number missing in second half
            else{
                low=mid+1;
            }
        }
        //check if element missing in low if not array is sorted
        if(low+1==arr[low])
        return -1;
        return low+1;
    }
}
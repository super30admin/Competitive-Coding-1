
// TC: O(logn)
// SC: O(1)
// Approach:
/*
 * Brute Force: Linear search if index != nums[index+1] then return that number is missing so return index+1
 * Optimized: Binary Search 
 * if (mid + 1 == arr[mid]) that means all the elements from start to mid are present so start = mid + 1 else end = mid - 1
 */

class Solution {
    int missingNumber(int arr[]) {
        // code here
        int start = 0;
        int end = arr.length - 1;
        
        while(start <= end){
            //int overflow
            int mid = start + (end - start) / 2;
            
            if(mid + 1 == arr[mid]){
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return start + 1;
    }
}

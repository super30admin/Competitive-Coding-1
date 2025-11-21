// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//saw the diff between the index and val is constant or not. if not then the number is missing

import java.io.*;

class GFG {

    static int search(int[] ar, int size) {
        int low =0;
        int high = size-1;

        while (high-low >= 2){
            int mid = low + (high-low)/2;
            int midDiff = ar[mid]- mid;
            int lowDiff = ar[low]-low;
            int highDiff = ar[high]-high;

            if (lowDiff == highDiff){
                return -1;
            }
            if (midDiff != lowDiff){
                high = mid;
            }else if (midDiff != highDiff){
                low = mid;
            }
        }
        return (ar[low] + ar[high])/2;
    
    }}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;
class Problem3 {
    public static void main(String args[]) {
        int[] arr = {3,4,7,2,-3,1,4,2,0,1};
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        // Add this for finding first subarray here in this case it is (3,4)7-7 = 0
        map.put(0,1);
        int rSum = 0;
        int resultCount = 0;
        int k = 7;
        for(int i = 0; i < arr.length; i++) {
            // store the running sum
            rSum+=arr[i];
            // if y-7 is already present then add it's count
            if(map.containsKey(rSum - k)) {
                resultCount = resultCount + map.get(rSum - k);
            }
            // if not present then add it to hashmap, increase count if the running sum is present
            if (!map.containsKey(rSum))
                map.put(rSum, 1);
            else 
                map.put(rSum, map.get(rSum) + 1);    
        }
        System.out.println(resultCount);
    }
}
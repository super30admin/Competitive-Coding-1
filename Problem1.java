/**
 * Time Complexity : O(n) 
 * Space Complexity : O(n)
 */

import java.util.HashSet;
import java.util.Set;

class Problem1 {
    public int missingNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int n:nums){
            hashSet.add(n);
        }
        
        for(int idx = 0; idx<nums.length+1; idx++){
            if(!hashSet.contains(idx))
                return idx;
        }
        return -1;
    }

    public static void main(String args[]){   
        Problem1 obj= new Problem1();  
        int[] myArr = new int[]{0,1,3,6,2,5};
        int result = obj.missingNumber(myArr);
        System.out.println(result+" is missing");

    }
}

/*
Problem :
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8

time Complexity : O(N)
Space Complexity : O(N)
Is run on leetcode : YES

*/
class Problem1 {
    public int missingNumber(int[] nums) {
        HashSet<Integer> s= new HashSet();
        int count = nums.length;
        // add in hashset 
        for(int i=0;i<count;i++){
            s.add(nums[i]);
        }
        // check if int contains in hashset
        // if not return integer
        for(int i=0;i<count+1;i++){
            if (!s.contains((Integer)i)){
                return i;
            }
        }       
        return -1;   
    }
}

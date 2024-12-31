/**
 * Time Complexity :O(log(n)) 
 * Space Complexity :O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this :no
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
   //nums.sort((a,b)=>a-b);
   var left=0,right=nums.length-1;
   while(left<=right){
     var mid = Math.floor((left+right)/2);
     nums[mid]==mid ? left = mid+1:right = mid-1;
   }
   return left;

};
console.log(missingNumber([3,0,1]));
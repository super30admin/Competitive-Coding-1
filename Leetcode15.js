// Time Complexity :O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
   var sum = nums.length*(nums.length+1)/2;
   var add = 0;
   for(let i of nums)
   {
       add +=i;
   }
   return sum-add;
};
console.log(missingNumber([1,2,4]));
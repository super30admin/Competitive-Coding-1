// When the array is SORTED, Time complexity = O(logn)
/**
 * @param {number[]} nums
 * @return {number}
 */
 var missingNumber = function(nums) {
    let low = 0;
    let mid = 0;
    let high = nums.length - 1;

    while (high - low >= 2) {
        mid = low + (high - low) / 2;
        
        let midIndexDiff = nums[mid] - mid;
        let lowIndexDiff = nums[low] - low;
        
        if (midIndexDiff !== lowIndexDiff) {
            high = mid;
        } else {
            low = mid;
        }
    }
    
    return (nums[low] + nums[high]) / 2;
};

// When the array is NOT SORTED, and zero is present in case of missing number. Time complexity = O(n) (Leetcode 268)
// we cannot sort the array nd apply binary search in this case.
// Because, for example, [0,1] is the given array of size 2, the output should be [2,1].
// But sorting [0,1] won't help our situation, since the sorted array is still [0,1].
// Plus, sorting will increase the time complexity additionally.

/**
 * @param {number[]} nums
 * @return {number}
 */
 var missingNumber = function(nums) {
    let sum = 0;
    for(let i = 0; i < nums.length; i++){
        sum += nums[i];
    }
    return nums.length * (nums.length + 1)/2 - sum;
};

findMissingInteger(nums){
    let low = 0;
    let high = nums.length -1;
    let mid;
    while(low<=high){
        mid = Math.floor(low + Math.floor((high-low)/2));
        if(mid != nums[mid]-1) return mid+1;
        if(mid == nums[mid]-2) high = mid-1;
        if(mid == nums[mid]-1) low = mid+1;
    }
    return mid+1;
}

//Procedure
/* if the array index of the element is not equal to value-1, then that
 number is the missing number. If the mid Index calculated is not equal to 
 value -1, then the mid position +1(value) calculated is the missing number.
 If the mid Index is equal to nums[mid]-2, then the missing number should be
 present in the left side of the array. Else, if mid Index is equal to
 nums[mid]-1, then the missing number will be present in the right side of the 
 array*/
 
 //TimeComplexity : O(logN) (binary search)

 //Space Complexity : O(1)
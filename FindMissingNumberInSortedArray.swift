//
//  FindMissingNumber.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/15/26.
//

/*
 If you are given a sorted array, find missing elements in between a range.
 [1, 2, 3, 4, 5, 6, 8, 9] ->
 take elements 1 and 6
 1, index = 0 => 1 - 0 = 1
 6, index = 5 => 6 - 5 = 1
 since the difference is same, so elements are not missing in between this range.
 
 check if you have an element missing between two elements - e.g. [6, 8]
 (6 + 8) / 2 = 7. means 7 is missing.
 
 
 Apply binary search.
 */
class FindMissingNumbers {
    
    init() {
        let r = findMissingElement([1, 2, 3, 4, 5, 8, 9])
        print("result is \(r)")
    }
    
    func findMissingElement(_ nums: [Int]) -> Int {
        
        var low = 0
        var high = nums.count - 1
        
        while ((high - low) >= 2) {
            let mid = low + (high - low) / 2
            let differenceOfLow = nums[low] - low
            let differenceOfMid = nums[mid] - mid
            let highIndexDifference = nums[high] - high
            
            if (differenceOfLow != differenceOfMid) {
                high = mid
            } else if (differenceOfMid != highIndexDifference) {
                low = mid
            }
           
            print("difference of lwo \(differenceOfLow) **** difference of mid \(differenceOfMid)")
        }
        print("low *** \(low) *** high \(high)")
        return (nums[low] + nums[high])/2 //resultArray
    }
    
}

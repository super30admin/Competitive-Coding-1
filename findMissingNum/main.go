package main

import "fmt"

/*
Provide an array of n-1 integers in the range of 1 to n with no duplicates in list,
One of the integers is missing in the list. Write a code to find the missing integer.

Examples:
Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
Output : 4

Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
Output : 3
*/

func findMissingNumber(nums []int) int {
	// brute force
	// start a loop from idx 0 and compare next element with current+1
	// if next number != current+1 then the nextNumber is the missing number
	// o(n) time and o(1) space ^

	// because the numbers are sorted we can somehow use binary search
	// how can we tell if mid the missing number?
	// check with mid-1 -- if the mid and mid-1 are not consecutive
	// then mid-1 is missing
	// then how do we find out whether we need to search left or right
	// what can we compare with mid from left and right? ( this is where I needed some hints.. sigh )
	// you can do a diff with midVal - leftVal = this tells us the number of elements that are supposed to exist between the 2 numbers
	// then can check how many actually exists between the two by doing midIdx - leftIdx
	// if the numberOfElementToExists != actualNumberOfElement - search that side or else the other side.

	if nums == nil || len(nums) == 0 {
		return -1
	}

	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + ((right - left) / 2)

		desiredPrev := nums[mid] - 1
		if mid != 0 && nums[mid-1] != desiredPrev {
			return desiredPrev
		}

		elementsToExistInLeftSide := nums[mid] - nums[left]
		actualNumOfElementsOnLeftSide := mid - left

		if elementsToExistInLeftSide != actualNumOfElementsOnLeftSide {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return -1
}

func main() {
	fmt.Println(findMissingNumber([]int{1, 2, 4, 5, 6, 7, 8, 9}))
	fmt.Println(findMissingNumber([]int{1, 2, 3, 4, 5, 7, 8}))
	fmt.Println(findMissingNumber([]int{3, 5, 6, 7, 8, 9}))
	fmt.Println(findMissingNumber([]int{1, 2, 3, 4, 5, 6, 7, 8, 9}))
	fmt.Println(findMissingNumber([]int{2, 3, 4, 5, 6, 7, 9}))
}

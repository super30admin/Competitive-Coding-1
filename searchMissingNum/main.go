package main

import "fmt"

func main() {
	fmt.Println(searchMissingNum([]int{1, 2, 3, 4, 5, 6, 7, 9, 10}))
	fmt.Println(searchMissingNum([]int{3, 5, 6, 7, 8, 9, 10}))
}

// time: o(logn)
// space: o(1)
func searchMissingNum(nums []int) int {
	if nums == nil || len(nums) <= 1 {
		return -1
	}

	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := left + (right-left)/2

		dist := right - mid
		prevNum := nums[mid-1]

		// is mid the missing number?
		if prevNum+1 != nums[mid] {
			return prevNum + 1
			// midVal+dist is supposed to give us the expected right value
			// if the expected right val @ right ptr != actual value @ right ptr ; then something on right is off; search right
		} else if nums[mid]+dist != nums[right] {
			left = mid + 1
			// otherwise, search left
		} else {
			right = mid - 1
		}
	}
	// no missing number
	return -1
}

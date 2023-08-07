func main() {
    fmt.Println(findMissing([]int{1, 2, 3, 4, 6, 7, 8}))
    fmt.Println(findMissing([]int{1, 3, 4, 5, 6, 7, 8}))
    fmt.Println(findMissing([]int{1, 2, 3, 4, 5, 6, 8, 9}))
}

/*
Given a list of n-1 integers and these integers are in the range of 1 to n.
There are no duplicates in list. One of the integers is missing in the list.
Write an efficient code to find the missing integer. 

Examples:

Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
Output : 5

Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
Output : 7

time : o(logN)
space: o(1)
*/

func findMissing(nums []int) int {
    n := len(nums)
    left := 0
    right := n-1
    for left <= right {
        mid := left + (right-left)/2        
        if (mid == 0 || nums[mid-1]+1 != nums[mid]) {
            return nums[mid-1]+1
        } else if mid == nums[mid]-1 {
            left = mid+1
        } else {
            right = mid-1
        }
    }
    return -1
}

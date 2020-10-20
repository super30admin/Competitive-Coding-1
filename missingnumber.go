// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
normal binary search with exit condition that difference between elements is same
*/
package main

import "fmt"

func search(ar []int, size int) int {
	a := 0
	b := size - 1
 	mid := 0
	for (b - a) > 1 {
		mid = a + (b - a) / 2
		if (ar[a] - a) != (ar[mid] - mid) {
			b = mid
		} else if (ar[b] - b) != (ar[mid] - mid) {
			a = mid
		}
	}
	return ar[mid] + 1
}

func MainMissingNumber () {
	ar := []int{ 1, 2, 3, 4, 5, 6, 8 }
    size := len(ar)
	fmt.Println("Missing number: ")
	fmt.Println(search(ar, size))
}



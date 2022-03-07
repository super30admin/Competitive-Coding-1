package main

import (
	"fmt"
	"math"
)

/*
Operations on Min Heap:

getMin(): It returns the root element of Min Heap. O(1)

extractMin(): Removes the minimum element from MinHeap.
			- This is done by swapping the idx 0 with lastIdx
			- Then dropping the last idx ( [:len(arr)-1] )
			- then heapify top-down as the top is now out-of-place

insert(): We add a new key at the end of the tree.
		- This is done by appending a new element to the back of the array
		- Then heapify bottomUp because the inserted item could be out of place when compared to its parent
*/

func main() {
	mn := NewMinHeap()
	for i := 0; i < 10; i++ {
		mn.Insert(i)
	}
	for len(mn.items) != 0 {
		fmt.Println(mn.Extract())
	}
}

type MinHeap struct {
	items []int
}

func NewMinHeap() *MinHeap {
	return &MinHeap{items: []int{}}
}

// worst case time and space: o(n)
// amortized time and space: o(1) space and o(logN) time
func (mn *MinHeap) Insert(val int) {
	// time: o(1) avg case
	// time and space: o(n) worse case when underlying array is full
	mn.items = append(mn.items, val)

	// time: o(logN)
	mn.heapifyUp(len(mn.items) - 1)

}

// o(1) space and o(logN) time
func (mn *MinHeap) Extract() int {
	out := mn.items[0]
	mn.swap(0, len(mn.items)-1)
	mn.items = mn.items[:len(mn.items)-1] // drop the last
	mn.heapifyDown(0)
	return out
}

func (mn *MinHeap) parent(idx int) int     { return int(math.Floor(float64((idx - 1) / 2))) }
func (mn *MinHeap) leftChild(idx int) int  { return 2*idx + 1 }
func (mn *MinHeap) rightChild(idx int) int { return 2*idx + 2 }
func (mn *MinHeap) swap(i, j int)          { mn.items[i], mn.items[j] = mn.items[j], mn.items[i] }

// time: o(logN) -- where N is the number of elements in the underlying array
// space: o(1)
func (mn *MinHeap) heapifyDown(idx int) {
	l := len(mn.items) - 1
	if idx < 0 || idx > l {
		return
	}
	left := mn.leftChild(idx)
	right := mn.rightChild(idx)
	for (left <= l && mn.items[left] < mn.items[idx]) || (right <= l && mn.items[right] < mn.items[idx]) {
		swappingWith := idx
		if left <= l && mn.items[left] < mn.items[swappingWith] {
			swappingWith = left
		}
		if right <= l && mn.items[right] < mn.items[swappingWith] {
			swappingWith = right
		}
		if swappingWith == idx {
			return
		}
		mn.swap(swappingWith, idx)
		idx = swappingWith
		left = (2 * idx) + 1
		right = (2 * idx) + 2
	}
}

// time: o(logN) -- where N is the number of elements in the underlying array
// space: o(1)
func (mn *MinHeap) heapifyUp(idx int) {
	l := len(mn.items) - 1
	if idx < 0 || idx > l {
		return
	}
	parent := int(math.Floor(float64((idx - 1) / 2)))
	for parent <= l && mn.items[idx] < mn.items[parent] {
		mn.swap(idx, parent)
		idx = parent
		parent = int(math.Floor(float64((idx - 1) / 2)))
	}
}

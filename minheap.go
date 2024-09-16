// Time Complexity : O(logn)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
to insert add element at end of array and move element up heap by comparing repeatedly with parent
to remove remove first element replace by last element and them move it down the heap by comparing with children
*/
package main

import "fmt"

type minheap struct {
	heapArr []int
	size int
	maxSize int
}

func newMinHeap(maxSize int) *minheap {
	minHeap := &minheap{
		heapArr: []int{},
		size: 0,
		maxSize: maxSize,
	}
	return minHeap
}

func (m *minheap) insert(item int) error {
	if m.size >= m.maxSize {
		return fmt.Errorf("heap is full")
	}
	m.heapArr = append(m.heapArr, item)
	m.size++
	m.upHeapify(m.size - 1)
	return nil
}

func (m *minheap) upHeapify(index int) {
	for m.heapArr[index] < m.heapArr[m.parent(index)] {
		m.swap(index, m.parent(index))
		index = m.parent(index)
	}
}

func (m *minheap) parent(index int) int {
	return (index - 1)/ 2
}

func (m *minheap) swap(first, second int) {
	temp := m.heapArr[first]
	m.heapArr[first] = m.heapArr[second]
	m.heapArr[second] = temp
}

func (m *minheap) remove() int {
	top := m.heapArr[0]
	m.heapArr[0] = m.heapArr[m.size - 1]
	m.heapArr = m.heapArr[:m.size - 1]
	m.size--
	m.downHeapify(0)
	return top
}

func (m *minheap) downHeapify(current int) {
	if m.leaf(current) {
		return
	}
	smallest := current
	leftChildIndex := m.leftChild(current)
	rightChildIndex := m.rightChild(current)
	if leftChildIndex < m.size && m.heapArr[leftChildIndex] < m.heapArr[smallest] {
		smallest = leftChildIndex
	}
	if rightChildIndex < m.size && m.heapArr[rightChildIndex] < m.heapArr[smallest] {
		smallest = rightChildIndex
	}
	if smallest != current {
		m.swap(current, smallest)
		m.downHeapify(smallest)
	}
	return
}

func (m *minheap) leaf(index int) bool {
	if index >= (m.size/2) && index <= m.size {
		return true
	}
	return false
}

func (m *minheap) leftChild(index int) int {
	return 2*index + 1
}

func (m *minheap) rightChild(index int) int {
	return 2*index + 2
}

func (m *minheap) buildMinHeap() {
	for index := (m.size/2) - 1; index >= 0; index-- {
		m.downHeapify(index)
	}
}

func MainMinHeap() {
	input := []int{6,5,3,7,2,8}
	minheap := newMinHeap(len(input))
	for i := 0; i < len(input); i++ {
		minheap.insert(input[i])
	}
	minheap.buildMinHeap()
	for i := 0; i < len(input); i++ {
		fmt.Println(minheap.remove())
	}
}


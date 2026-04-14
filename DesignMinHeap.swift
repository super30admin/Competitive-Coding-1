//
//  DesignMinHeap.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/15/26.
//

struct MinHeap<T: Comparable> {
    
    var elements: [T] = []
    
    var isEmpty: Bool {
        return elements.isEmpty
    }
    
    var count: Int {
        return elements.count
    }
    
    var min: T? {
        return elements.first
    }
    
    mutating func insert(_ value: T) {
        elements.append(value)
        heapifyUp(from: elements.count - 1)
    }
    
    mutating func heapifyUp(from index: Int) {
        var childIndex = index
        var parentIndex = (childIndex - 1) / 2
        while (childIndex > 0 && elements[childIndex] < elements[parentIndex]) {
            elements.swapAt(childIndex, parentIndex)
            childIndex = parentIndex
            parentIndex = (childIndex - 1) / 2
        }
    }
    
    mutating func delete(_ value: T) -> T? {
        elements.swapAt(0, elements.count - 1)
        let r = elements.removeLast()
        heapifyDown(from: 0)
        return r
    }
    
    mutating func heapifyDown(from index: Int) {
        var parentIndex = index
        var leftChildIndex = (2 * parentIndex) + 1
        
        while (leftChildIndex < count) {
            
            var childIndex = leftChildIndex
            
            var rightChildIndex = leftChildIndex + 1
            
            if (rightChildIndex < count && elements[rightChildIndex] < elements[leftChildIndex]) {
                childIndex = rightChildIndex
            }
            
            if (elements[parentIndex] < elements[childIndex]) {
                break
            }
            
            elements.swapAt(parentIndex, childIndex)
            parentIndex = childIndex
            leftChildIndex = (2 * parentIndex) + 1
        }
    }
}

class MinHeapImpl {
    
    init() {
        var minHeap = MinHeap<Int>()
        minHeap.insert(10)
        minHeap.insert(15)
        minHeap.insert(2)
        minHeap.insert(11)
        minHeap.insert(7)
        minHeap.insert(8)
        let removed = minHeap.delete(2)
        print("removed \(removed)")
        
        let min = minHeap.min ?? -1
        print("minimum *** \(min)")
    }
}

class MinHeap {
    constructor(){
        this.heap = [];
    }
    
    // get the index of the parent of the node at index i
    parentIndex(i){
        return Math.floor((i-1)/2);
    }
    
    // left child at index i
    leftChildIndex(i){
        return 2 * i + 1;
    }
    
    // right child at index i;
    rightChildIndex(i){
        return 2 * i + 2;
    }
    
    // swap the elements at index i and j
    swap(i, j){
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }
    
    // insert
    insert(val){
        this.heap.push(val);
        this.heapifyUp();
    }
    
    // ensure heap property is maintained after pushing new value
    heapifyUp(){
        let idx = this.heap.length - 1;
        while (idx > 0 && this.heap[idx] < this.heap[this.parentIndex(idx)]){
            this.swap(idx, this.parentIndex(idx));
            idx = this.parentIndex(idx);
        }
    }
    
    // extract min value from heap
    extract(){
        if(this.heap.length === 0){
            throw new Error("Heap is Empty");
        }
        if(this.heap.length === 1){
            return this.heap.pop();
        }
        const min = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.heapifyDown(0);
        return min;
    }
    
    // ensure the heap property is maintained after extraction
    heapifyDown(idx){
        let min = idx;
        const left = this.leftChildIndex(idx);
        const right = this.rightChildIndex(idx);
        
        if(left < this.heap.length && this.heap[left] < this.heap[min]){
            min = left;
        }
        
        if(right < this.heap.length && this.heap[right] < this.heap[min]){
            min = right;
        }
        
        if(min !== idx){
            this.swap(idx, min);
            this.heapifyDown(min);
        }
    }
    
    // get min value without extraction
    getMin() {
        if (this.heap.length === 0){
            throw new Error("Heap is Empty");
        }
        return this.heap[0];
    }
}

 //driver code
const minHeap = new MinHeap();
minHeap.insert(3);
minHeap.insert(1);
minHeap.insert(6);
minHeap.insert(5);
minHeap.insert(2);
minHeap.insert(4);

console.log(minHeap.getMin()); // 1
console.log(minHeap.extract()); // 1
console.log(minHeap.getMin()); // 2
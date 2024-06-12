//Time Complexity: extract and insert - O (log n),  getMin - O (1)
//Space Complexity: O (1)
//Runs: yes

class MinHeap {
    constructor() {
        this.values = [];
    }

    getMin() {
        if (!this.values) return [];
        return this.values[0];

    }

    extractMin() {
        const min = this.values[0];
        const last = this.values.pop();
        if (this.values.length) {
            this.values[0] = last;
            this.bubbleDown();
        }

        return min;

    }

    bubbleDown() {
        let idex = 0;
        const elem = this.values[idex];
        while (true) {
            let lChildIdx = 2 * idex + 1;
            let rChildIdx = 2 * idex + 2;
            let lChild, rChild;
            let swapIndex = null;

            if (lChildIdx < this.values.length) {
                lChild = this.values[lChildIdx];
                if (lChild < elem) {
                    swapIndex = lChildIdx;
                }
            }

            if (rChildIdx < this.values.length) {
                rChild = this.values[rChildIdx];
                if ((swapIndex === null && rChild < elem)
                    || (swapIndex !== null && rChild < lChild)) {
                    swapIndex = rChildIdx;
                }
            }

            if (swapIndex === null) break;
            this.values[idex] = this.values[swapIndex];
            this.values[swapIndex] = elem;
            idex = swapIndex;
        }
    }

    insert(element) {
        this.values.push(element);
        this.bubbleUp();
    }

    bubbleUp() {
        let idex = this.values.length - 1;
        const elem = this.values[idex];
        while (idex > 0) {
            let parentIdx = Math.floor((idex - 1) / 2);
            let parentElem = this.values[parentIdx];
            if (elem >= parentElem) break;
            this.values[parentIdx] = elem;
            this.values[idex] = parentElem;
            idex = parentIdx;
        }
    }


}

let minHeap = new MinHeap();
minHeap.insert(41);
minHeap.insert(39);
minHeap.insert(33);
minHeap.insert(18);
minHeap.insert(27);
minHeap.insert(12);
minHeap.insert(55);
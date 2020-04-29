//Priority Queue with Linked List

class Node {
    constructor(val, priority) {
        this.priority = priority;
        this.val = val;
        this.next = null;
    }
}

class PriorityQueue {
    constructor() {
        this.head = null;
    }
    push(val, priority) {
        let temp = new Node(val, priority);
        if(!this.head) {
            this.head = temp; 
            return this;
        } 
        let cur = this.head;
        if(temp.priority < cur.priority) {
            this.head = temp;
            this.head.next = cur;
            return this;
        }
        while(cur.next) {
            if(cur.priority < temp.priority && temp.priority < cur.next.priority) {
                temp.next = cur.next;
                cur.next = temp;
                return this;
            }
            cur = cur.next;
        }
        cur.next = temp;
        return this;
    }
    pop() {
        let temp = this.head;
        this.head = this.head.next;
        return temp.priority;
    }
}

let pq = new PriorityQueue()
pq.push(1,3)
pq.push(1,4)
pq.push(1,2)
pq.push(1,6)
pq.push(1,7)
pq.push(1,5)
pq.push(1,1)

console.log(pq.pop())
console.log(pq.pop())
console.log(pq.pop())
console.log(pq.pop())
console.log(pq.pop())
console.log(pq.pop())
console.log(pq.pop())



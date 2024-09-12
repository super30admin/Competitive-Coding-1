// Time Complexity : O(1) for getting min, O(log n) for inserting
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : Problem description was vague not sure what needs to be designed
// Time taken : 10

import java.util.PriorityQueue;

public class MinHeap {

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int getMin(){
        return pq.peek();
    }

    public int extractMin(){
        return pq.poll();
    }

    public void insert(int n){
        pq.add(n);
    }
}

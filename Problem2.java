//Min Heap using PriorityQueue
//Time complexity: O(log N) for insert and delete
//Space complexity: O(N)
class Solution {

    public static void main(String args[]) {
        PriorityQueue<Integer> queue = PriorityQueue<>();

        queue.add(10);
        queue.add(30);
        queue.add(20);
        queue.add(40);

        //Print head value
        System.out.println("Head value: " + queue.peek());

        //print elements in the heap
        Iterator itr = queue.Iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Removing the head element
        queue.poll();
        System.out.println("After removing an element: ");
 
        Iterator<Integer> itr2 = queue.iterator();
 
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }
 
        // Removing 30 using remove()
        queue.remove(30);
        System.out.println("After removing 30: ");
 
        Iterator<Integer> itr3 = queue.iterator();
        while (itr3.hasNext()) {
            System.out.println(itr3.next());
        }    
 
        // Check if an element is present using contains()
        boolean b = queue.contains(20);
        System.out.println("Is 20 present in heap: " + b);
 
        // Getting objects from the queue using toArray()
        // in an array and printing the array
        Object[] arr = queue.toArray();
        for (int i = 0; i < arr.length; i++)
            System.out.println("Value: "+ arr[i].toString());        
    }
}
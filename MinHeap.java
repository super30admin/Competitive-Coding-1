//time Complexity: get minimum => O(1) // root element
//space Complexity: O(n)

class ImplementMinHeap{
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    //Helper methods to lookup in the tree/heap
    private int getLeftChildIndex(int parentIndex){
        return 2 * parentIndex + 1;
    }
    private int getRightChildIndex(int parentIndex){
        return 2 * parentIndex + 2;
    }
    private int getParentIndex(int index){
        return (index - 1)/2;
    }

    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }
    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }
    private boolean hasParent(int index){
        return getParentIndex(index) >=0;
    }

    private int leftChild(int index){
        return items[getLeftChildIndex(index)];
    } 
    private int rightChild(int index){
        return items[getRightChildIndex(index)];
    }
    private int parent(int index){
        return items[getParentIndex(index)];
    }

    //Swap elements in array/heap
    private void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    //Increase the array capacity if needed
    private void ensureExtraCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity = capacity * 2;
        }
    }

    public int peek(){
        if(size == 0){
            throw new IllegalStateException();
        }
        return items[0];
    }

    //Remove elemenet from heap ==> heapify down
    public int poll(){
        if(size == 0){
            throw new IllegalStateException();
        }
        int item = items[0];
        items[0] = items[size - 1]; //Remmove root element/first element
        size--;

        heapifyDown(); //Tree is imbalanced so heapifyDown

        return item;
    }

    //Add element to heap
    public void add(int item){
        ensureExtraCapacity();

        items[size] = item;
        size++;
        heapifyUp();  //Tree may be imbalanced so heapifyUp
    }

    private void heapifyUp() {
        int index = size -1;

        while(hasParent(index) && parent(index) > items[index]){
            swap(index, getParentIndex(index));
        }

        index = getParentIndex(index);
    }

    private void heapifyDown() {
        int index = 0;

        while(hasLeftChild(index)){
            int smallerIndexChild = getLeftChildIndex(index);
            // Check if right child is smaller than left --> swap
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerIndexChild = getRightChildIndex(index);
            }

            if(items[index] < items[smallerIndexChild]){
                break; // Everything is correct
            }
            else{
                swap(index, smallerIndexChild);
            }
            index = smallerIndexChild;
        }
    }
}


// Min Heap Implementation
// Time Complexity:
// To get min: O(1)
// To insert element: O(log n)
// To remove min element: O(log n)
// Space Complexity: O(n)
class Problem2 {

    private int maxSize;
    private int heapArray[];
    private int frontIndex;

    public Problem2(int maxSize){
        this.maxSize = maxSize;
        this.heapArray = new int[maxSize];
        this.frontIndex = 0;
    }

    public int getParentIndex(int i){
        return (i-1)/2;
    }

    public int getLeftChildIndex(int i){
        return 2 * i + 1;
    }

    public int getRightChildIndex(int i){
        return 2 * i + 2;
    }

    public int findMin(){
        if(frontIndex == 0) {
            System.out.println("\nHeap is empty");
            return -1;
        }
        return heapArray[0];
    }

    public void insertElement(int value){
        if(frontIndex == maxSize) {
            System.out.println("\nHeap is full");
            return;
        }

        int currentIndex = frontIndex;
        heapArray[frontIndex++] = value;
        while(currentIndex != 0 && heapArray[currentIndex] < heapArray[getParentIndex(currentIndex)]){
            int temp = heapArray[currentIndex];
            heapArray[currentIndex] = heapArray[getParentIndex(currentIndex)];
            heapArray[getParentIndex(currentIndex)] = temp;
            currentIndex = getParentIndex(currentIndex);
        }
        System.out.println("\nAfter inserting " + value );
        printHeap();
        return;
    }

    public void removeMin(){
        if(frontIndex == 0) {
            System.out.println("\nHeap is Empty");
            return;
        }
        int minElement = heapArray[0];
        heapArray[0] = heapArray[--frontIndex];

        this.heapify(0);
        System.out.println("\nRemoving min element: " + minElement);
        this.printHeap();
    }

    private void heapify(int i) {
        int leftIndex = this.getLeftChildIndex(i);
        int rightIndex = this.getRightChildIndex(i);
        int swapPosition = i;

        if(rightIndex < frontIndex){
            swapPosition = heapArray[leftIndex] < heapArray[rightIndex] ? leftIndex : rightIndex;
        }else if(leftIndex < frontIndex){
            swapPosition = leftIndex;
        }

        if(swapPosition != i && heapArray[swapPosition] < heapArray[i]){
            int temp = heapArray[swapPosition];
            heapArray[swapPosition] = heapArray[i];
            heapArray[i] = temp;
            this.heapify(swapPosition);
        }
        return;
    }

    public void printHeap(){
        for(int i=0; i< frontIndex; i++){
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Problem2 customHeap = new Problem2(10);

        customHeap.insertElement(50);
        customHeap.insertElement(80);
        customHeap.insertElement(30);
        customHeap.insertElement(90);
        customHeap.insertElement(20);
        customHeap.insertElement(10);
        customHeap.insertElement(40);
        customHeap.insertElement(70);
        customHeap.insertElement(100);
        customHeap.insertElement(60);
        customHeap.insertElement(1);

        System.out.println("\nMin element is: " + customHeap.findMin());

        customHeap.removeMin();
        customHeap.removeMin();
        customHeap.removeMin();
        customHeap.removeMin();
        customHeap.removeMin();
        customHeap.removeMin();
        customHeap.removeMin();
        customHeap.removeMin();
        customHeap.removeMin();
        customHeap.removeMin();
        customHeap.removeMin();
    }
}

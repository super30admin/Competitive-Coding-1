public class TestCompetitiveCoding1 {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(4);
        minHeap.insert(6);
        minHeap.insert(7);
        minHeap.print();
        System.out.println("The Min val is "
                + minHeap.remove());
        minHeap.print();
        // Test for the missing element
        int arr[] = {1,2,3,4,6,7,8};
        System.out.println("Missing element in an array is "+MissingElement.missingNumber(arr));
    }
}

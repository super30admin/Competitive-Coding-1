public class Problem2 {

    int[] heap;
    int size;
    int maxSize;

    //I did not quite understand this problem implementation so I will ask extra help from the TAs this week
    public Problem2(int maxSize) {
        this.heap = new int[maxSize];
        this.size = 0;
    }

    public insert(int value) {
        if (this.size <= this.maxSize) {
            this.heap[this.size - 1] = val;
            this.size++;
        } else {
            this.moveUp(value);
        }
    }

}

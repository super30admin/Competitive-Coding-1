/*
  Time complexity: GetMin O(1); ExtractMin O(log n); Insert O(log n)
  Spaxce complexity: O(n)

  Approach: An array is used to store the values of a min heap where each element is less than or equal to it's children. Root is the minimum element in the array and is retrieved in O(1) time complexity.

*/
public class MinHeap
{
    private List<int> heap;

    public MinHeap()
    {
        heap = new List<int>();
    }

    private int Parent(int i) => (i - 1) / 2;

    private int Left(int i) => 2 * i + 1;

    private int Right(int i) => 2 * i + 2;

    private void Swap(int i, int j)
    {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void Insert(int key)
    {
        heap.Add(key);
        int i = heap.Count - 1;

        // Bubble up
        while (i != 0 && heap[Parent(i)] > heap[i])
        {
            Swap(i, Parent(i));
            i = Parent(i);
        }
    }

    public int GetMin()
    {
        if (heap.Count == 0)
            throw new InvalidOperationException("Heap is empty");
        return heap[0];
    }

    public int ExtractMin()
    {
        if (heap.Count == 0)
            throw new InvalidOperationException("Heap is empty");

        if (heap.Count == 1)
        {
            int min = heap[0];
            heap.RemoveAt(0);
            return min;
        }

        // Store the minimum value, and remove it from heap
        int root = heap[0];
        heap[0] = heap[heap.Count - 1];
        heap.RemoveAt(heap.Count - 1);
        MinHeapify(0);

        return root;
    }

    // Maintains the min heap property
    private void MinHeapify(int i)
    {
        int left = Left(i);
        int right = Right(i);
        int smallest = i;

        if (left < heap.Count && heap[left] < heap[smallest])
            smallest = left;
        if (right < heap.Count && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != i)
        {
            Swap(i, smallest);
            MinHeapify(smallest);
        }
    }

    public int Size() => heap.Count;
}

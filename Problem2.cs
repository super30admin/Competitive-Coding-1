using System;

class MinHeap
{
    // Time Complexity:
    // - Insert: O(log n)
    // - Remove: O(log n)
    // - MinHeapify: O(log n)
    // - Print: O(n)
    // Space Complexity: O(n)

    private int[] heap;
    private int size;
    private int maxsize;

    private static readonly int FRONT = 1;

    public MinHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize + 1];
        heap[0] = int.MinValue;
    }

    private int Parent(int pos) { return pos / 2; }

    private int LeftChild(int pos) { return 2 * pos; }

    private int RightChild(int pos) { return (2 * pos) + 1; }

    private bool IsLeaf(int pos)
    {
        return pos > (size / 2);
    }

    private void Swap(int fpos, int spos)
    {
        int temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }

    private void MinHeapify(int pos)
    {
        if (!IsLeaf(pos))
        {
            int swapPos = pos;
            if (RightChild(pos) <= size)
                swapPos = heap[LeftChild(pos)] < heap[RightChild(pos)] ? LeftChild(pos) : RightChild(pos);
            else
                swapPos = LeftChild(pos);

            if (heap[pos] > heap[swapPos])
            {
                Swap(pos, swapPos);
                MinHeapify(swapPos);
            }
        }
    }

    public void Insert(int element)
    {
        if (size >= maxsize)
            return;

        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[Parent(current)])
        {
            Swap(current, Parent(current));
            current = Parent(current);
        }
    }

    public void Print()
    {
        for (int i = 1; i <= size / 2; i++)
        {
            Console.WriteLine($"PARENT: {heap[i]}, LEFT CHILD: {heap[2 * i]}, RIGHT CHILD: {heap[2 * i + 1]}");
        }
    }

    public int Remove()
    {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        MinHeapify(FRONT);
        return popped;
    }

    public static void Main(string[] args)
    {
        MinHeap minHeap = new MinHeap(15);

        minHeap.Insert(5);
        minHeap.Insert(3);
        minHeap.Insert(17);
        minHeap.Insert(10);
        minHeap.Insert(84);
        minHeap.Insert(19);
        minHeap.Insert(6);
        minHeap.Insert(22);
        minHeap.Insert(9);

        Console.WriteLine("The Min Heap is:");
        minHeap.Print();

        Console.WriteLine("The Min value is " + minHeap.Remove());
    }
}

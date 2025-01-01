using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Coding
{
    internal class MinHeap
    {
        int[] heap;
        int capacity;
        int size;
        const int front = 1;

        public MinHeap()
        {
            this.capacity = 15;
            heap = new int[this.capacity];
            size = 0;
        }

        public int Parent(int position)
        {
            return heap[position / 2];
        }

        public int LeftChild(int position)
        {
            if (2 * position > size)
            {
                return -1;
            }
            return heap[2 * position];
        }

        public int RightChild(int position)
        {
            if (2 * position + 1 > size)
            {
                return -1;
            }
            return heap[2 * position + 1];
        }

        public int Peek()
        {
            return heap[front];
        }

        public int Size()
        {
            return size;
        }

        public void Swap(int x, int y)
        {
            int temp = heap[x];
            heap[x] = heap[y];
            heap[y] = temp;
        }

        public bool IsLeafNode(int position)
        {
            return (position >= heap.Length / 2);
        }

        public void Print()
        {
            for (int i = front; i <= heap.Length / 2; i++)
            {
                Console.WriteLine($"for {heap[i]} leftChild is {LeftChild(i)} and rightChild is {RightChild(i)}");
            }
        }

        public void Heapify(int position)
        {
            if (IsLeafNode(position) || position == 0)
            {
                return;
            }
            var swapNode = position;

            if (LeftChild(position) < heap[position])
            {
                swapNode = 2 * position;
            }
            else if (RightChild(position) < heap[position])
            {
                swapNode = 2 * position + 1;
            }

            Swap(swapNode, position);
            Heapify(swapNode);
        }

        public void Add(int element)
        {
            if (size >= capacity)
            {
                Console.WriteLine("Cannot add more elements");
                return;
            }
            heap[++size] = element;
            var current = size;

            while (size != 1 && heap[current] < Parent(current))
            {
                Swap(current, current / 2);
                current = current / 2;
            }
        }

        public int Remove()
        {
            int top = heap[front];
            heap[front] = heap[size--];
            Heapify(heap[front]);
            return top;
        }
    }
}

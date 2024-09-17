/**

// Time Complexity :
	Building a Heap - logn
	HEapSort - nlogn
	insert - logn
	remove- logn
	getMin - O(1)
 O(logn) 
// Space Complexity : O(1) since there is no additional space used.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

**/
class MinHeap {
    
    int size;
    int arr[];
    int currentptr = -1;
    
    MinHeap(int size)
    {
        this.size = size;
        arr = new int[this.size];
    }
    
    public void delete()
    {
        if (currentptr == -1)
        {
            return;
        }
        
        int temp = arr[0];
        arr[0] = arr[currentptr];
        arr[currentptr] = 0;
        currentptr--;
        
        heapifyDown(0, currentptr);
    }
    
    // Assumptions : This is a separate function i wrote for heapsort nothing to do with this class.
    // 4 7 8 5 1 9
    public int[] applyHeapSort(int input[])
    {
        int n = input.length;
        for(int i=n/2 -1; i>=0; i--)
        {
            // apply the heapifyDown at each parent of subtree.
            heapifyDown(i, n);
        }
        
        for(i=n; i>=0; i--)
        {
            // extract the root since it is max
            int max = input[0];
            input[0] = input[i];
            input[i] = max;
            
            // applyHeapifyDown process at index 0.
            heapifyDown(0, i - 1);
        }
        
        return input;
    }
    
    public void print()
    {
        for (int n : arr)
        {
            System.out.println(n);
        }
    }
    
    public void heapifyDown(int index, int length)
    {
        int root = index;
        int left = 2*root + 1;
        int right = 2*root + 2;
        
        int min = root;
        
        if (left >=0 && left < length && arr[left] < arr[min])
        {
            min = left;
        }
        
        if (right >= 0 && right < length && arr[right] < arr[min])
        {
            min = right;
        }
        
        if (min != root)
        {
            int temp = arr[min];
            arr[min] = arr[root];
            arr[root] = temp;
            
            heapifyDown(min, length);
        }
    }
    
    public void insert(int input)
    {   
        arr[++currentptr] = input;
        
        heapifyUp(currentptr);
    }
    
    private int getParent(int index)
    {
        return (index - 1) / 2;
    }
    
    private void heapifyUp(int index)
    {
        int parentIndex = getParent(index);
        
        while (parentIndex >= 0 && arr[parentIndex] > arr[index])
        {
            int temp = arr[index];
            arr[index] = arr[parentIndex];
            arr[parentIndex] = temp;
            
            index = parentIndex;
            parentIndex = getParent(index);
        }
    }
}


class Practice {
    
    public static void main(String args[])
    {
        MinHeap mH = new MinHeap(8);
        mH.insert(9);
        mH.insert(8);
        mH.insert(3);
        mH.insert(4);
        mH.insert(5);
        mH.delete();
        mH.print();
    }
}
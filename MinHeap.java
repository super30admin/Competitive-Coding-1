
// Time Complexity : O(log n)
// Space Complexity : O(n)

public class MinHeap{

    private int[] arr;
    private int size;
    private int capacity;

    MinHeap(int c)
    {
        arr=new int[c];
        size=0;
        capacity=c;
    }
    int left(int i)
    {
        return (2*i+1);
    } 
    int right(int i)
    {
        return (2*i+2);
    } 
    int parent(int i)
    {
        return (i-1)/2;
    } 
    void insert(int x)
    {
        //if size is equal to capacity we return
        if(size==capacity)return;
        //we increase the size;
        size++;
     
        arr[size-1]=x;
       
        for(int i=size-1;i>0 && arr[parent(i)]>arr[i];)
        {
            swap(arr,i,parent(i));
            i=parent(i);
        }
    }
    void minHeapify(int i)
    {
        
        int left=left(i);
        int right=right(i);
        int smallest=i;
        if(left<size && arr[left]<arr[i])
         smallest=left;
        if(right<size && arr[right]<arr[i])
         smallest=right;
        if(smallest!=i)
        {
            swap(arr, i, smallest);
            minHeapify(smallest);
        }
    }

    int getMin()
    {

        if(size==0)
        return Integer.MIN_VALUE;

        return arr[0];
    }

    int extractMin()
    {

        if(size==0)
        return Integer.MIN_VALUE;
        if(size==1)
        {
            size--;
            return arr[0];

        }
        swap(arr, 0, size-1);
        size--;
        minHeapify(0);
        return arr[size];
    }

    void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args)
    {
        MinHeap obj=new MinHeap(5);
        obj.insert(3);
        obj.insert(4);
        obj.insert(1);
        System.out.println(obj.getMin());
        System.out.println(obj.extractMin());
        System.out.println(obj.getMin());
    }

}
import javax.lang.model.util.ElementScanner6;

class MinHeap{
int[] arr;
int size;
int maxsize;
    MinHeap(int size)
    {
        this.maxsize=size+1;
        arr= new int[maxsize];
        this.size=0;
        arr[0]=Integer.MIN_VALUE;
    }
    private int parent(int index)
    {
        return index/2;
    }
    private int left(int index)
    {
        return index*2;
    }
    private int right(int index)
    {
        return (index*2)+1;
    }
    boolean isLeaf(int pos)
    {
        if(pos>=(size/2) && pos<=size)
            return true;
        return false;
    }
    void swap(int pos1, int pos2)
    {
        int temp=arr[pos1];
        arr[pos1]= arr[pos2];
        arr[pos2]=temp;
    }
    void heapify(int pos)
    {
        if(!isLeaf(pos))
        {
            if(arr[left(pos)]<arr[pos] || arr[right(pos)]<arr[pos])
            {
                if(arr[left(pos)]<arr[right(pos)])
                {
                swap(pos,left(pos));
                heapify(left(pos));
                }
                else
                {
                swap(pos,right(pos));
                heapify(right(pos));
                 }
            }
        }
    }
    void insert(int x)
    {
        if(size>=maxsize)
            return;
        arr[++size]=x;
       int curr=size;
       while(arr[curr]<arr[parent(curr)])
       {
           swap(curr,parent(curr));
           curr=parent(curr);
       }
    }
    int getMin()
    {
        return arr[1];
    }
    int extractMin()
    {
        int pop= arr[1];
        arr[1]=arr[size--];
        heapify(1); 
        return pop;
    }
    void printheap()
    {
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + arr[i] 
                             + " LEFT  : " + arr[2 * i] 
                             + " RIGHT :" + arr[2 * i + 1]); 
            System.out.println(); 
        }
    }

    public static void main(String args[])
    {
        MinHeap obj = new MinHeap(7);
        obj.insert(20);
        obj.insert(12);

        obj.insert(13);

        obj.insert(2);

        obj.insert(10);

        obj.insert(1);
        System.out.println(obj.getMin());
        System.out.println( obj.extractMin());
        obj.insert(3);
        System.out.println(obj.extractMin());
        System.out.println(obj.getMin());
        obj.printheap();
    }
}
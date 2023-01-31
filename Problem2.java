// Design min heap
public class Problem2
{
    int size;
    int []arr = new int[20];

    public void addValue(int val)
    {
        arr[size] = val;
        int index = size;
        int parent = (index-1)/2;

        while(parent>=0 && arr[index]<arr[parent])
        {
            int temp = arr[index];
            arr[index]=arr[parent];
            arr[parent]=temp;
            index=parent;
            parent=(index-1)/2;
        }
        size++;
    }

    public int removeMin()
    {
        int min = arr[0];
        arr[0]=arr[size-1];
        size-=1;
        heapify(0);
        return min;
    }

    public int getMin()
    {
        return arr[0];
    }

    public void heapify(int index)
    {
        int l = index*2+1;
        int r = index*2+2;

        int smallest = index;
        if(l<this.size && arr[l]<arr[smallest])
        {
            smallest=l;
        }
        if(r<this.size && arr[r]<arr[smallest])
        {
            smallest=r;
        }
        
        if(smallest!=index)
        {
            int temp = arr[smallest];
            arr[smallest] = arr[index];
            arr[index]=temp;
            heapify(smallest);
        }
    }

    public static void main(String []args)
    {
        Problem2 a = new Problem2();
        int []arr = {10,7,11,30,20,38,2,45};

        a.addValue(arr[0]);
        a.addValue(arr[1]);
        a.addValue(arr[2]);

        System.out.println("Min is " + a.getMin());

        a.addValue(arr[3]);
        a.addValue(arr[4]);
        System.out.println("Min is " + a.getMin());

        a.addValue(arr[5]);
        System.out.println("Min is " + a.getMin());

        a.addValue(arr[6]);
        a.addValue(arr[7]);
        System.out.println("Min is " + a.getMin());

        System.out.println("Deleted element is : "+a.removeMin());
        System.out.println("Min is " + a.getMin());

        System.out.println("Deleted element is : "+a.removeMin());
        System.out.println("Min is " + a.getMin());

        System.out.println("Deleted element is : "+a.removeMin());
        System.out.println("Min is " + a.getMin());

        System.out.println("Deleted element is : "+a.removeMin());
        System.out.println("Min is " + a.getMin());

        System.out.println("Deleted element is : "+a.removeMin());
        System.out.println("Min is " + a.getMin());
    }
}

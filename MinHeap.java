//Time Complexity : insert- O(logn) extractMin - 0(logn) getMin - O(1)
//Space Complexity : O(n)
//Not Sure if it's on leetcode
//Problem : To handle the edge cases in extractMin

/*
Here we are using linkedlist as underlying data structure
At the time of adding the element, we add it as the last node of the linked list
    After the we need to check if it's in the correct position and if not, we need to make swap the child and parents nodes
At the time of removing the element, we'll remove the first element and put the last element over there
    After that we will be swapping the parent and child elements to make sure that the heap structure is maintained
 */



import java.util.LinkedList;

public class MinHeap {
    static LinkedList<Integer> ll;
    MinHeap()
    {
        ll = new LinkedList<>();
    }
    public void insert(int a)
    {
        ll.add(a);
        if(ll.size()!=1) {
            AddCheck(ll.size()-1);
        }
    }
    public static void AddCheck(int index)
    {
        int childIndex = index;
        int parentIndex = (index - 1)/2;
        while(ll.get(parentIndex)>=ll.get(childIndex) )
        {
            int temp = ll.get(childIndex);
            ll.set(childIndex,ll.get(parentIndex));
            ll.set(parentIndex,temp);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1)/2;
            if(childIndex==0)
            {
                break;
            }
        }
    }
    public static void remove()
    {
        int nodeToBeRemoved = ll.get(0);
        ll.set(0,ll.get(ll.size()-1));
        ll.remove(ll.size()-1);
        int parentIndex = 0;
        if(ll.size()==1) return;
        int childnode1Index = (parentIndex*2) + 1;
        int childnode2Index = (parentIndex*2) + 2;
        while((childnode1Index>ll.size()-1 || ll.get(parentIndex)>ll.get(childnode1Index))
                && (childnode2Index>ll.size()-1 || ll.get(parentIndex)>ll.get(childnode2Index)))
        {
            int lesserValueIndex;
            if(childnode2Index>ll.size()-1)
            {
                if(childnode1Index>ll.size()-1)
                {
                    return;
                }
                else
                {
                    lesserValueIndex = childnode1Index;
                }
            }
            else
            {
                lesserValueIndex = ll.get(childnode1Index) < ll.get(childnode2Index) ? (childnode1Index) : (childnode2Index);
            }
            int temp = ll.get(parentIndex);
            ll.set(parentIndex,ll.get(lesserValueIndex));
            ll.set(lesserValueIndex,temp);
            parentIndex = lesserValueIndex;
            childnode1Index = (parentIndex*2) + 1;
            childnode2Index = (parentIndex*2) + 2;
        }
    }
    public void extractMin()
    {
        if(!isEmpty())
        {
            remove();
        }
    }
    public void display()
    {
        if(!isEmpty()) {
            for (int i = 0; i < ll.size() - 1; i++) {
                System.out.print(ll.get(i) + " --> ");
            }
            System.out.println(ll.get(ll.size() - 1));
        }
    }
    public int getMin()
    {
        if(!isEmpty())
        {
            return ll.get(0);
        }
        else
        {
            return -999;
        }
    }
    public boolean isEmpty()
    {
        if(ll.size()==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {

        MinHeap mh = new MinHeap();

        mh.insert(10);
        mh.display();
        mh.insert(4);
        mh.display();
        mh.insert(15);
        mh.display();
        mh.extractMin();
        mh.display();
        mh.insert(20);
        mh.display();
        mh.insert(0);
        mh.display();
        mh.insert(30);
        mh.display();
        mh.extractMin();
        mh.display();
        mh.extractMin();
        mh.display();
        mh.insert(2);
        mh.display();
        mh.insert(4);
        mh.display();
        mh.insert(-1);
        mh.display();
        mh.insert(-3);
        mh.display();







    }
}

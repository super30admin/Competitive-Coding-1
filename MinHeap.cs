using System.Collections;
using System.Reflection.Metadata;

namespace LeetCodeSubmission.CompetitiveCoding1;

public class MinHeap
{
    // data-members
    public ArrayList minHeap;

    public MinHeap()
    {
        this.minHeap = new ArrayList();
    }
    
    // functions
    private void BubbleUp()
    {
        // base-case
        if (this.minHeap.Count == 1)
        {
            return;
        }

        // logic-case
        int child = this.minHeap.Count - 1;
        int parent = -1;
        
        while (true)
        {
            // set the parent value
            if (child % 2 == 0)
            {
                //even idx
                parent = (child / 2) - 1;
            }
            else
            {
                // odd idx
                parent = (child / 2);
            }
            
            // min-heap chk
            if (parent >= 0 && (int)this.minHeap[child] < (int)this.minHeap[parent])
            {
                // swap
                int temp = (int)this.minHeap[child];
                this.minHeap[child] = this.minHeap[parent];
                this.minHeap[parent] = temp;
                
                // update the idx
                child = parent;
                continue;
            }

            break; // else break the loop
        }
    }

    private void BubbleDown()
    {
        if (this.minHeap.Count <= 1)
        {
            return;
        }

        int parent = 0;

        while (true)
        {
            int child1 = 2 * parent + 1;
            int child2 = 2 * parent + 2;

            // base-case
            if (this.minHeap.Count-1 < child1)
            {
                // reached the limit
                break;
            }
            else if (this.minHeap.Count - 1 >= child1 && this.minHeap.Count - 1 < child2)
            {
                // just compare with child1 only
                if ((int)this.minHeap[parent] > (int)this.minHeap[child1])
                {
                    int temp = (int)this.minHeap[parent];
                    this.minHeap[parent] = this.minHeap[child1];
                    this.minHeap[child1] = parent;
                    
                    // update the parent
                    parent = child1;
                    continue;
                }

                break; // condition is satisfied
            }
            else
            {
                // compare with both child1 and child2
                if ((int)this.minHeap[child1] <= (int)this.minHeap[child2])
                {
                    if ((int)this.minHeap[parent] > (int)this.minHeap[child1])
                    {
                        int temp = (int)this.minHeap[parent];
                        this.minHeap[parent] = this.minHeap[child1];
                        this.minHeap[child1] = temp;
                    
                        // update the parent
                        parent = child1;
                        continue;
                    }
                    
                    break; // condition is satisfied
                }
                else
                {
                    if ((int)this.minHeap[parent] > (int)this.minHeap[child2])
                    {
                        int temp = (int)this.minHeap[parent];
                        this.minHeap[parent] = this.minHeap[child2];
                        this.minHeap[child2] = temp;
                    
                        // update the parent
                        parent = child2;
                        continue;
                    }
                    break; // condition is satisfied
                }
            }
        }
    }
    public void Insert(int x)
    {
        // add the element inside the minHeap
        this.minHeap.Add(x);
        
        // bubble-up
        this.BubbleUp();
        
        Console.WriteLine("min-heap-insertion= "+ string.Join(", ",minHeap.ToArray()));
    }

    public void GetMin()
    {
        if (this.minHeap.Count == 0)
        {
            Console.WriteLine("empty-min heap");
        }
        Console.WriteLine("get-min= "+this.minHeap[0]);
    }

    public void ExtractMin()
    {
        // base-case
        if (this.minHeap.Count == 0)
        {
            Console.WriteLine("empty-min heap");
        }
        
        // logic-case
        // swap 0th index with last index
        int temp = (int)this.minHeap[0];
        this.minHeap[0] = this.minHeap[this.minHeap.Count - 1];
        this.minHeap[this.minHeap.Count - 1] = temp;
        
        // remove the last-index value from the list
        this.minHeap.RemoveAt(this.minHeap.Count-1);
        // Console.WriteLine("min-heap-extractMin-before-bubble-down= "+string.Join(", ",this.minHeap.ToArray()));
        
        // bubble-down
        this.BubbleDown();
        
        Console.WriteLine("min-heap-extractMin= "+string.Join(", ",this.minHeap.ToArray()));
    }
    
}
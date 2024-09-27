

class Solution 
{
    public int search(ArrayReader reader, int target) 
    {
        int low=0;
        int high=1;
    
        if(reader.get(0)==Integer.MAX_VALUE)
        {
            return -1;
        }
        
        while(target > reader.get(high))
        {   
            low=high;
            high=high*2;
             if(reader.get(high)== target)
            {
                return high;
            }
            
        }
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            
            if(reader.get(mid) == target)
            {
                return mid;
            }
            else if(reader.get(mid) > target)
                    
                    {
                        
                        high = mid-1;
                    }
                    else
                    {
                        low= mid+1;
                    }
        }
                    
               return -1;     
      }
}

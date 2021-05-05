package HashFunction;

import java.util.Arrays;
import java.util.HashMap;

public class FindIndexesOfTargetSum {
    
    public static int[] searchIndexes(int[] array,int sum)
    {
        int rsum =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<array.length;i++)
        {
            
            int diff = sum - array[i];
            if(map.containsKey(diff))
            {
                return new int[] {i,map.get(diff)};
            }
            map.put(array[i], i);
        }
        
        return new int[] {};
    }
}

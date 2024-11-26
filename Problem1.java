// Time Complexity : O(logn)
// Space Complexity : O(1)

import java.util.*;

class MissingNumber {

   // with binay search approch
    public int missingNumberWithBinarysearch(int[] numArray) {
    
       int low = 0, high = numArray.length-1;
        int missingNumber = -1;
        
        while(low <= high) {
            
           int mid = low + (high - low) / 2;
            
            if(numArray[mid]-mid == 1 )
               return numArray[mid]-1;
                    
            else if(numArray[mid]-mid == numArray[low]-low)
                low = mid;
            
            else if(numArray[mid]-mid == numArray[high]-high)
               high = mid;
                          
        }
        return -1;
    }

//with hashset
// Time Complexity : O(n)
// Space Complexity : O(n)
 public int missingNumberWithHashSet(int[] numArray) {
    
        int expectedCount = numArray.length + 1;
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i=0; i <= numArray.length-1; i++) {
         set.add(numArray[i]);
        }
       
       for (int j = 0; j < expectedCount; j++) {
            if (!set.contains(j)) {
                return j;
            }
        }
        return -1;
    }
    

    public static void main(String[] args) {
    MissingNumber mnObj =  new MissingNumber();
    int[] numArray = {0,1,2,3,5,6};
    System.out.println("with Hash Set:" + mnObj.missingNumberWithHashSet(numArray));
    System.out.println("with binary search:" + mnObj.missingNumberWithBinarysearch(numArray));
    }
}

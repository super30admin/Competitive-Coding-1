import java.util.HashSet;

class Solution {
    public int findMissingNumber(int[] arr, int n) {
        HashSet<Integer> hashSet = new HashSet<Integer>(); 
       
        for (int i = 0; i < n-1; i++) {
            hashSet.add(arr[i]);
        }
        
        
        for (int i = 1; i <= n; i++) {
            
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        
        return n+1;
    }
}

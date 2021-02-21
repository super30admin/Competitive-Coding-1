//Problem 15 : kth Missing Number in a sorted array ranging from 1 to n-> can be implemented for 1st missing number starting from 1 to n
//TC : O(log(n)), n is number of elements in a given array
//SC : O(1)

class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(arr==null || arr.length==0) return 1;
        
        //Binary Search
        //TC: O(logN), SC:O(1)
        int start = 0;
        int end   = arr.length-1;
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            
            int numOfMissElem = arr[mid]-mid-1;//here subtracting 1 because even if no element is missing the difference b/w element n index will be 1; 
            
            if(k>numOfMissElem){//means at current index less element are missing on left side, so moving pointer to right side.
                start = mid+1;
            }else{
                end   = mid-1;
            }
        }
        
        /*Because
        idx               0 1 2 3 4 5 6 7 8 9  10  
        No elem missing : 1 2 3 4 5 6 7 8 9 10 11
        
        idx              : 0 1 2 3 4
        elem missing     : 2 3 4 7 11
        
        in above case start is at 4, 5th missing element is at 8th index above, so start+k will be the answer
        */
        return start + k;//start is index
        
        /*
        //TC:O(N), SC:O(N)
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++) set.add(arr[i]);
        
        int lastElem = arr[arr.length-1]; 
        for(int i=1;i<=lastElem;i++){
            
            if(!set.contains(i)){
                k--;
            }
            
            if(k==0) return i;
            
        }*/
        
        //return lastElem+k;
    }
}



        
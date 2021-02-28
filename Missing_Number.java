// Time Complexity : O(logn)
// Space Complexity : O(1)

// Your code here along with comments explaining your approach

class Missing_Number {
    public int missingNumber(int[] arr) {
        int low=0;
        int high=arr.length-1;
       
       
        if(arr[high]!=arr.length) return arr.length;
        //if(arr[low]!=0) return 0;
       
        while(low<=high){
            int mid = low+(high-low)/2;
           
            if((arr[mid]!=mid)&&(mid==0|| arr[mid]-arr[mid-1]>1)){
                return arr[mid]-1;
            }
            else if(arr[mid]!=mid){
                high=mid-1;
            }
            else{
                System.out.println("Inside low");
                low=mid+1;
            }
        }
        return -1;
    }
}

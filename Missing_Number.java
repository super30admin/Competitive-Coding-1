// Time Complexity : O(logn)
// Space Complexity : O(1)
//Aproach: I am using binary search here, at each value value of mid, I am searching if my value is equal to it's indice+1.
//If it is not greater, the array to left is not sorted and I check if the element missing is right beside my mid value, if it is then i return the same.
//If array is sorted, my value art mid is equal to indice+1 , then i move my right pointer i.e low=mid+1;

// Your code here along with comments explaining your approach

class Missing_Number {
    public int missingNumber(int[] arr) {
        int low=0;
        int high=arr.length-1;
       
        //If missing number is at the end of array
        if(arr[high]!=arr.length) return arr.length;
        //if(arr[low]!=0) return 0;
       
        while(low<=high){
            int mid = low+(high-low)/2;
            
            //This is my base condition where i check if array to the left is sorted and if number missing is right beside my mid
            if((arr[mid]!=mid+1)&&(mid-1==0|| arr[mid]-arr[mid-1]>1)){
                return arr[mid]-1;
            }
            //If second condition i my base condition falls, it means that array is not sorted to the left but element is still in left array
            else if(arr[mid]!=mid+1){
                high=mid-1;
            }
            
            //If both condition fails, move to right subarray
            else{
                System.out.println("Inside low");
                low=mid+1;
            }
        }
        return -1;
    }
}

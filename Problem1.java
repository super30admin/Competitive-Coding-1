// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MissingNumber{
    int low, high, mid;
public int missednumber(int arr[]){
    low=0; 
    mid=0;
    high = arr.length -1;
    while((high-low)>1){
        mid= (high+low)/2;
    
    if(arr[low]-low != arr[mid]-mid){
        high=mid;
    }
    else if(arr[high]-high != arr[mid]-mid){
        low=mid;
    }
}
    return arr[low]+1;
}
}

class Main { 
    public static void main(String args[]) 
    { 
        int arr[]={-2,-1,0,2,3,4,5,6,8};
        MissingNumber missing= new MissingNumber();
        System.out.println(missing.missednumber(arr)); 
    } 
}
//Time Complexity: O(logn)
//Space Complexity: O(1)
class interview{
    int low = 0;
    int high = arr[s].length -1;
    
    int binarySearch(int arr[]){
        while(high-low>1){
        mid = low + (high-low)/2;
             
        if(arr[mid]-arr[low]!=mid-low){
            high=mid;
        }
        else{
            low=mid;
        }
    }
    return (low+high)/2;
}
}

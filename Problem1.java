class MissingNo{
public static int binarySearch(int arr[], int size){
    int low = 0; int high = size - 1;
    int mid = 0;
    while(high-low>=2){
        mid = low +(high-low)/2;
        int midIndexdiff = arr[mid] - mid;
        int lowIndexdiff = arr[low] - low;
        if(midIndexdiff != lowIndexdiff){
            high = mid ;}
        else
            low = mid ;
        }
    //if(arr[high]-arr[low] >= 2)
    return ((arr[low] + arr[high])/2);
    //else
    //return arr.length+1; 
}

public static void main(String[] args){
    int arr[] = {1,2};
    int size = arr.length;
    System.out.println("Missing no: "+ binarySearch(arr,size));}
}

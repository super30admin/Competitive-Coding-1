
class SearchMissingElement{
   
    public static int search(int[] arr){
     
     int low = 0,high = arr.length - 1;
     while(low <= high){
        int mid = low + (high - low)/2;
        if(arr[mid] != mid+1 && arr[mid-1] == mid){
            return mid+1;
        }else if(arr[mid] != mid+1){
            high = mid - 1;
        }else{
            low = mid +1;
        }
     }
     return -1;
    }
     public static void main(String[] args)
    {
        int ar[] = { 1, 2, 3, 4, 6,7,8};
        //int size = ar.length;
        System.out.println("Missing number: "
                           + search(ar));
    }


}
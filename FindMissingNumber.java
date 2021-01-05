class FindMissingNumber{
    public static int findMissingElement(int []arr){
        int low=0;
        int high=arr.length-1;
        int diff=arr[low]+1;
      //int arr[]={1,2,3,5,6,7,8};
        while(low<high-1){
            int mid=low+(high-low)/2;
            if(arr[mid]-mid==diff){
                high=mid;
            }
            else{
                low=mid;
            }
        }
        return (arr[high]- 1);
    }
    public static void main(String args[]){
        //int arr[]={1,2,3,5,6,7,8};
        //int arr[]={5,6,7,8,10,11};
        int arr[]={3,4,5,6,8,9};
    }
}

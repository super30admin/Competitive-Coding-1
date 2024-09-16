class MissingNum {
    static int findMissing(int[] arr){
        int low=0; int high=arr.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid]-mid != 1 && arr[mid-1] == mid) {
                return mid + 1;
            }
            else if(arr[mid] == mid+1) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        int arr[] = {1,2,3,4,6,7,8};
        int Number = findMissing(arr);
        System.out.println(Number);
    }
}
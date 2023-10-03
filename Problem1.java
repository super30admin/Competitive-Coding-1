class FindMissingNumberSortedArray{
    public static void main(String args[]){
        int[] arr = new int[]{1,2,3,4,6,7};
        int low = 0, high = arr.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if((arr[mid] - mid) > 1 && (arr[mid] - arr[mid-1]) !=1){
                System.out.println(arr[mid]-1);
                system.exit(0);
            }
            else if(arr[mid] - mid == 1){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        System.out.println("-1");
    }
}

Time Complexity : O(log N)
Space Complexity : O(1)
class Problem1 {

    public int findMissingNumber(int arr[], int size) {

        int low = 0;
        int high = size - 1;

        if(arr[0] != 1)
            return 1;

        if(arr[size - 1] != size + 1)
            return size + 1;

        while(low <= high) {

            int mid = low + (high - low)/2;

            if(mid == arr[mid - 1] && arr[mid] != mid +1 ){
                return mid + 1;
            }
            else if((arr[low] - low  == 1) && (arr[mid] - mid == 1)){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }

        }
        return -1;

    }

    public static void  main(String[] args) {
        Problem1 obj = new Problem1();
        int arr[] = {1,2, 3, 4, 5, 7};
        int size = arr.length;
        System.out.println(obj.findMissingNumber(arr,size));
    }
}

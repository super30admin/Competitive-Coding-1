class Problem1 {
    public static int getMissingElement(int []arr) {
        int low = 0;
        int high = arr.length - 1;
        int k = 1; // TO find the generalized missing element in an array.
        while(low<=high) {
            int mid = low + (high -low)/2;
            int missing = arr[mid] - (mid+1);
            if(missing < k) {
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return high + 1 + k;
        
    }
    
    public static void main(String[] args) {
        //int []arr = {1,2,3,4,6,7,8};
        int []arr = {1,3,4,5,6,7,8};
        System.out.println(getMissingElement(arr));
    }
}
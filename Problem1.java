class MissingNumber {
    public static Integer findMissingNumber(int[] arr){
        int start = arr[0];
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == mid+start){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        // No missing number
        if (low == arr.length) {
            return null;
        }
        return (low+start);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("Missing number: " + findMissingNumber(arr));
    }
}


class Problem1 {
    //o(logn) time and cons space
    public static int search(int[] arr, int size){
        int low = 0; int high = size - 1; 
         int mid = 0;
        while(high - low >= 2){
            mid = low + (high - low ) /2;

            int midIdx = arr[mid] - mid;
            int lowIdx = arr[low] - low;
            int highIdx = arr[high] - high;

            if(midIdx != lowIdx){
                high = mid;
            } else if(midIdx != highIdx){
                low = mid;
            }
        
        }
        return (arr[low] + arr[high]) / 2;


    }
    public static void main(String[] args) {
        int[] arr1 = new int[] {5,6,8,9,10};
        int size = arr1.length;
        System.out.println(search(arr1, size));
    }
}
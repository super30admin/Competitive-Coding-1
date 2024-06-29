public class Main {
    public static void main(String[] args) {
        int arr[] = {1,3,4,5,6,7,8,9};
        int low = 0;
        int high = arr.length -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] != mid+1) {
                high = mid - 1;
            } else if(arr[mid] == mid+1) {
                low = mid + 1;
            }
        }
        System.out.println(low+1);
    }
}

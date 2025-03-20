
class MissingNumber{
    public static int search (int arr[], int size){
        int low = 0;
        int mid = 0;
        int high = size-1;

        while(high - low >= 2){
            mid = low + (high-low)/2;
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;
            if(midIdxDiff != lowIdxDiff){
                high = mid;
            } else {
                low = mid;
            }
        }
        return (arr[low] + arr[high])/2;
    }

    public static void main(String[] args){
        int arr[] = {1,2,3,5,6,7,8};
        int size = arr.length;
        System.out.println("Missing number: "+search(arr, size));
    }
}

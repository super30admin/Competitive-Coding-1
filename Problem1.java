//Time complexity: O(N(log(N))
//Space complexity: O(1)

class Problem1{

    public static int search(int arr[], int size){

        int low =0;
        int high = size-1;
        int mid = 0;

        while(high-low>=2){
            mid = low + (high-low)/2;
            int middiff = arr[mid] - mid;
            int lowdiff = arr[low] - low;
            int highdiff = arr[high] - high;
            if(middiff != lowdiff){
                high = mid;
            }else{
                low = mid;
            }
        }
        return (arr[low]+ arr[high])/2;
    }



}
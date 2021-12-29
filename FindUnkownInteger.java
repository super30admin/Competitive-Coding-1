public class Array {

    public static int missingNum(int[] arr){

        int low = 0;
        int high = arr.length-1;

        while(low <=high){
            int mid = low + (high - low) / 2;
//            if(arr[mid] != mid + 1){
//                high = mid-1;
//            }
            if(arr[mid] != mid + 1 && arr[mid-1] == mid + 1){
                return mid;
            }else if(arr[mid] != mid +1){

                high = mid -1;

            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

            int[] ar = {1,2,3,4,6,7,8};

        System.out.println(missingNum(ar));


    }
    }
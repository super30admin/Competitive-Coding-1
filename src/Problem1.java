
public class Problem1 {
    public static int searchMissing(int[] arr) {
        int missingNum = -1;
        int low = 0;
        int high = arr.length-1;

        while(low<=high) {
            System.out.println("Low : " + low);
            System.out.println("high : " + high);
            if(high - low == 1) {
                if(arr[low]-low > 1) {
                    return arr[low]-1;
                } else {
                    return arr[high]-1;
                }
            }
            int mid = low + ((high-low)/2);
            int midItem = arr[mid];
            if(midItem - mid > 1) {
                // move left
                high = mid;
            } else {
                // move right
                low = mid;
            }
        }

        return missingNum;
    }

    public static int searchMissingStartingAnyNumber(int[] arr) {
        int missingNum = -1;
        int low = 0;
        int high = arr.length-1;
        int offsetDiff = arr[0] - 0;

        while(low<=high) {
            System.out.println("Low : " + low);
            System.out.println("high : " + high);
            if(high - low == 1 && low != 0) {
                if(arr[low]-low > offsetDiff) {
                    return arr[low]-1;
                } else {
                    return arr[high]-1;
                }
            }
            int mid = low + ((high-low)/2);
            int midItem = arr[mid];
            if(midItem - mid > offsetDiff) {
                // move left
                high = mid;
            } else {
                // move right
                low = mid;
            }
        }

        return missingNum;
    }
    public static void main(String[] args) {

        // int[] arr = {1, 2, 3, 4, 5, 6, 7, 9};
        int[] arr = {1, 2, 3, 4, 6, 7, 8, 9};
        System.out.println("Missing Item : " + searchMissing(arr));
//
//        int[] arr1 = {1, 3, 4, 5, 6, 8, 7, 9};
//        System.out.println("Missing Item : " + searchMissingStartingAnyNumber(arr1));

        // Missing 1st index

    }
}

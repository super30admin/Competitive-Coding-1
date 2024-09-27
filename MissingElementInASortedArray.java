/*
* You are given a sorted array and numbers are starting from 1 to n and one of the numbers is missing.
* Find the missing number in the array*/

class MissingElementInASortedArray {

//    This approach does not work if numbers do not start from 1 eg. [3, 5, 6, 7, 8] Ans should be 4
    private int findMissingElement(int[] arr) {
        int low = 0, high = arr.length - 1;

        while(low < high) {
            int mid = low + (high - low)/2;

            if(arr[mid] - mid > 1 && arr[high] - high > 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (low + 1) ;
    }

    private int approach2(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(high - low >= 2) {
            mid = low + (high - low) / 2;
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;
            int highIdxDiff = arr[high] - high;
            if(midIdxDiff != lowIdxDiff) {
                high = mid;
            } else if(midIdxDiff != highIdxDiff) {
                low = mid;
            }
        }
        return (arr[low] + arr[high]) /2;
    }

    public static void main(String[] args) {
        MissingElementInASortedArray solution = new MissingElementInASortedArray();
        int[] input1 = new int[] { 1, 2, 3, 4, 5, 6, 8};
        int res1 = solution.findMissingElement(input1);
        System.out.println(res1);
        int res2 = solution.approach2(input1);
        System.out.println(res2);
    }
}

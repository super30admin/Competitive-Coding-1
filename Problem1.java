// Find Missing Number in a sorted array

class MissingNumber {

    int findMissingNumber(int[] arr) {
        
        if ( arr == null || arr.length < 2) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] != mid + 1) {

                if( arr[mid] == mid + 2 ) {
                    return mid + 1;
                } else {
                    high = mid - 1;
                }

            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main (String args[]) {

        MissingNumber mn = new MissingNumber();

        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {1, 2, 3, 4, 5, 7};

        System.out.println(mn.findMissingNumber(arr1));
        System.out.println(mn.findMissingNumber(arr2));
        System.out.println(mn.findMissingNumber(arr3));


    }

}
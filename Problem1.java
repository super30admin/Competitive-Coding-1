class Problem1{
    private int findMissingNumberInSortedArray(int[] array){
        int low = 0;
        int high = array.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(low == high && mid + 1 < array[mid]){
                return array[low] - 1;
            } else if(mid + 1 == array[mid]){
                low = mid + 1;
            } else if(mid + 1 < array[mid]){
                high = mid - 1;
            }
        }
        return array[low] - 1;
    }

    public static void main(String[] strs){
        int number = new Problem1().findMissingNumberInSortedArray(new int[]{1,2,4,5,6,7});
        System.out.println(number);
    }
}

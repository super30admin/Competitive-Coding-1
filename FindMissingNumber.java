//Find Missing Number in a sorted array
class FindMissingNumber{
    public static void main(String args[]){
        int[] array = new int[]{1,2,3,4,6,7};
        int low = 0;
        int high = array.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if((array[mid] - mid) > 1 && (array[mid] - array[mid-1]) !=1){
                System.out.println(array[mid]-1);
                return;
            }
            else if(array[mid] - mid == 1){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
    }
}
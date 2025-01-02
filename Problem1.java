//Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.
//        Examples:
//
//Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
//Output : 5
//
//
//Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
//Output : 7


//approach is to use tweaked binarySearch
//the base case here is that if we want to find missing number between 2 no ->  [5,7] ->5+7/2->6 this will be our result base case
class Problem1 {
    public static int search(int[] arr){
        int low = 0;
        int high = arr.length-1;
        while((high-low)>=2){//because we want to reach a point where there are 2 elements only left where we know the missing number lies between them
            int mid = low +(high-low)/2;
            int lowDiff = arr[low]-low;
            int highDiff = arr[high] - high;
            int midDiff = arr[mid]-mid;

            if(lowDiff!=midDiff){
                high = mid;
            }
            else if(midDiff != highDiff){
                low = mid;
            }
        }
        return (arr[low]+arr[high])/2;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,7};
        System.out.println("missing number :"+search(arr));
    }
}

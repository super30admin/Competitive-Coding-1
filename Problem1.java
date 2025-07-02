//Time complexity ->O(logn)
//Spacse complexity->O(1)
// when we have two numbers and we take the sum of those two numbers/2 will give the mid number. now we have to find
//the two numbers in which a mid number is missing. We will compare the index differences of mid, low and high, if the differences
// is same means that range has no missing number discard that and search in the other half and when we are
//left witth two numbers we will come out of while loop and return the sum/w which will be the missing number.

class Main {
    private static int BinarySearch(int[]arr){
        int low=0;
        int high= arr.length-1;
        int mid=0;
        while(high- low>=2){
            mid = low+(high-low)/2;
            int midIndexDiff = arr[mid]-mid;
            int lowIndexDiff = arr[low]-low;
            int highIndexDiff = arr[high]-high;
            if(midIndexDiff !=lowIndexDiff){
                high = mid;
            }
            else{
                low =mid;
            }
        }
        return(arr[low]+ arr[high])/2;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,6,7,8};
        int result = BinarySearch(arr);
        System.out.println("Missing number is: " + result);
    }
}
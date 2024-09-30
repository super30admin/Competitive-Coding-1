public class Problem1 {

    private static int findMissingElement(int[] arr){
        int l=0, h = arr.length-1;
        int m;
        while(l<=h){
            m = l + (h-l)/2 ; 
            if(arr[m] - arr[m-1] == 2){
                return arr[m-1] +1;
            }
            else if(arr[m+1] - arr[m] == 2){
                return arr[m] + 1;
            }
            int actual_length_right = arr[h] - arr[m] + 1;
            int length_right = h - m + 1;
            if(actual_length_right - length_right !=0){
                l = m+1;
            }
            int actual_length_left = arr[m] - arr[l] + 1;
            int length_left = m - l + 1;
            if(actual_length_left - length_left !=0){
                h = m-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = { 1,2,3,4,5,6,8};
        int missingNumber = findMissingElement(arr);
        System.out.println("The missing number in the array is" + missingNumber);

    }

    
}


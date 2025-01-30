//The approach here is to use Binary Search to find the missing element.
//The main idea is that for a number greater than the missing number, the difference between the index and it's number is 2. 
//Whereas the difference is 1 if the number is less than the missing number.
//Time complexity: O(log n)
//Space complexity: O(1)

class Main {
    public static int missingNumber(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int num = 0;
        while(low<high){
            int mid = low + (high - low)/2;
            if(arr[mid] - mid == 2){
                high = mid;
            }
            else{
                low = mid+1;
            }
            num = arr[high];
        }
        return num-1;
    }
}


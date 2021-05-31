//Find Missing Number in Array
/*
Given a sorted array arr[] of N integers, The task is to find the multiple missing elements in the array between the ranges [arr[0], arr[N-1]].

Examples:

    Input: arr[] = {6, 7, 10, 11, 13}
    Output: 8 9 12 
    Explanation: 
    The elements of the array are present in the range of the maximum and minimum array element [6, 13]. Therefore, the total values will be {6, 7, 8, 9, 10, 11, 12, 13}. 
    The elements from the above range which are missing from the array are {8, 9, 12}. 
     

    Input: arr[] = {1, 2, 4, 6}
    Output: 3 5

*/

//Solution :

public class Main {
    public static void main(String[] args) {
        // [1,2,3,5,6] ans = 4, n = 6 -> Working
        // [2,3,4] ans = 1, n = 4 -> Working
        // [1,2,3,4] ans = 5, n = 5 -> Working
        // [1] ans = 2, n = 2 -> Working
        // [2] ans = 1, n = 2 -> Working
        int[] numbersSet = new int[]{1, 2, 3, 4, 5, 6, 8, 9};
        int n = numbersSet.length+1;
        System.out.println(findMissingNumber(numbersSet, n));
        
    }
    
    public static int findMissingNumber(int[] numbersSet, int n) {
        int low = 0;
        int high = numbersSet.length - 1;
        int missingNumber = n;
        if(numbersSet.length == 0) missingNumber = -1;
        if(numbersSet.length == 1) {
            if(numbersSet[0] == 2) missingNumber = 1;
            return missingNumber;
        } 
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(low == high && numbersSet[low]!= mid+1) {
                missingNumber = mid+1;
                break;
            }   
            if(numbersSet[mid] == mid + 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return missingNumber;
    }
}


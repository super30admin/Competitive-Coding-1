// Time Complexity : O(log(n)) we search using binary search. 
// Space Complexity : O(1) we do not store any elements

public static int findMissingElement(int[] arr){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
        int mid = low + (high - low)/2;
        if(mid == 0 && arr[mid] != 1){
        return 1;
        }else if(mid > 0 && arr[mid - 1] < arr[mid] - 1){
        return arr[mid] - 1;
        }else if(mid < arr.length && arr[mid + 1] > arr[mid] + 1){
        return arr[mid] + 1;
        }else if(arr[mid] > mid  + 1){
        high = mid - 1;
        }else{
        low = mid + 1;
        }
        }

        return -1;
        }
/*
TC: O(N) N - length of array
SC: O(1) constant space

1. As the array contains number between 1 to n, the actual indices of number if none is missing will be n - 1. 
2. We do a binary search by checking if the difference bw indices and number != 1.
3. If 1 or 8 is missing, then the differences will be same. 
4. We decide by comparing the number and index = 0 & number and index = length - 1. 

*/

public class MissingInteger{


    public static int missingInteger(int[] arr){

        int l = 0, h = arr.length - 1, mid = 0;
        boolean edge = false;

        while((h - l) > 1){
            //mid = l + (h-l)/2;
            mid = (l + h)/2;

            if((arr[mid] - mid) != (arr[l] - l)){
                h = mid;
            }else if((arr[mid] - mid) != (arr[h] - h)){
                 l = mid;
            }else{
                edge = true;
                break;
            }
        }

        if(edge){
           if((l + 1) != arr[l]) return 1;
           else return h = arr.length + 1;
        }

        return arr[l] + 1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,5,6,7,8};
        System.out.println(missingInteger(arr));
    }
}

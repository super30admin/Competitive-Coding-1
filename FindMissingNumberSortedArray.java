//Problem Name: Interview Problem: Find Missing Number in a sorted array
//Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. 
//Write an efficient code to find the missing integer. 

//Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
//Output : 5

//Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
//Output : 7

//I was able to figure out a linear solution for this. I was able to map this out as a binary search problem but could not come up with the conditions.
//TC = o(log n)
//SC = o(1)
public class FindMissingNumberSortedArray {

    public int findMissingNumber(int[] arr){
        int low = 0;
        int high = arr.length-1;
        
        while(high - low >= 2){
            int mid = low + (high - low)/2;
            int difflow = arr[low] - low;
            int diffmid = arr[mid] - mid;
            int diffhigh = arr[high] - high;
            if(difflow != diffmid){
                high = mid;
            }
            else if(diffmid != diffhigh) {
                low = mid;
            }
        }

        return (arr[low] + arr[high])/2;
    }
    public static void main(String[] args) {
        FindMissingNumberSortedArray f = new FindMissingNumberSortedArray();
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9};
        System.out.println(f.findMissingNumber(arr));
        
    }
}

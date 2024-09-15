// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class GFG{
    public static int search(int arr[], int size){
        int low = 0;
        int high = size - 1;
        int mid = 0;

        while(high - low >= 2){

            mid = low + (high - low)/2;
            
            //calculating the differences between the index and the element at the index
            int midIdxDiff = arr[mid] - mid;
            int lowIdxDiff = arr[low] - low;
            int highIdxDiff = arr[high] - high;

            //if the differences between the low and the mid don't match means there is a num missing in between 
            if(midIdxDiff != lowIdxDiff){
                high = mid;
            }
            //if diff between mid and high don't match then there is a num missing in between 
            else if(midIdxDiff != highIdxDiff){
                low = mid;
            }
        }
        //we return the middle value between the final high and low values because that is the number missing
        return (arr[low] + arr[high])/2;

    }

    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5, 6, 8};

        int size = arr.length;

        System.out.println("Missing number is: " + search(arr, size));
    }
}

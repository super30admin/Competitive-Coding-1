//Time Complexity : O(log n)
//Finding the missing number in a sorted array
//We are trying to find two numbers where the number is missing using the binary search technique and then returning the
//mean of those two numbers to get the missing value . Here we are subtracting the value with the index value and looking at the difference .

public class missing {
    public static int missing(int arr[],int size){
        int low =0;
        int high = arr.length -1;
        int mid =0;
        while(high-low >=2) // termination condition
        {
            mid = low+(high-low)/2;
            int midIndex = arr[mid] -mid;
            int lowIndex = arr[low] -low;
            if(midIndex != lowIndex){
                high =mid;
            }else{
                low = mid;
            }


        }

        return (arr[low] +arr[high])/2;  //we are left with two numbers in which the missing number lies in between .

    }

    public static void main (String[] args){
        int ar[]={3,4,5,6,7,8,9,11};
        int size= ar.length;
        System.out.println("Missing Number is " + missing(ar,size));
    }
}
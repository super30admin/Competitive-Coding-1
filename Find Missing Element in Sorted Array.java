//Space Complexity = O(1)
//Time Complexity = O(log N)

public class MissingElement{

    public static int missingelement(int[] arr)
    {
        // if(arr[0]!=1)
        //     return 1;
        int d=1;
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            
            if(arr[mid+1] - arr[mid]!=d || mid==end)
            {
                return arr[mid]+d;
            }
            else if(arr[mid]-arr[mid-1]!=d || mid==start)
            {
                return arr[mid]-d;
            }
            if(arr[end] - arr[mid] != end-mid)
            {
                start=mid+1;
            }
            else if(arr[mid]-arr[start] != mid-start)
            {
                end=mid-1;
            }
        }
        return 0;
    }
     public static void main(String []args){
        int []arr={2,3,4,5,6,7,8};
        System.out.println(missingelement(arr)+" ");
     }
}
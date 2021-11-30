//Time complexity:O(lg(N))
// Space complexity:O(1) // constant space 

public class Problem1{
    int findMissingElement(int arr[]){
        int low=0;
        int high=arr.length-1;
        int mid=0;
        while(low<=high){
            mid=low+(high-low)/2;
            if(arr[mid]==mid+1){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return mid+1;
    }
    public static void main(String args[]){
            Problem1 obj=new Problem1();
            int arr[]={1,2,3,4,6};
            int res=obj.findMissingElement(arr);
            System.out.println("the missing element in the array is: "+res);
    }
}

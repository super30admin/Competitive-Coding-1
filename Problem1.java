

class Solution{

    public int searchMissingelement(int [] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low+1<high){
            mid=low+(high-low)/2;
            System.out.println("inside while low = "+ low + " high = "+high+ " mid = "+mid);
            if(arr[mid]==mid+1){
                low=mid;
            }else if(arr[mid]>mid+1){
                high=mid;
            }
        }
        return arr[low]+1;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int a[]=new int[]{1,2,3,5,6,7,8,9,10};
        int misselement=s.searchMissingelement(a);
        System.out.println("miss = "+misselement);
    }

}
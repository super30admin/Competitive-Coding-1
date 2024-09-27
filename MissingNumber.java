public class MissingNumber {
    public int missingNum(int[] arr){

        if(arr == null || arr.length==0) return -1;
        int low=0;
        int high = arr.length-1;
        int size = arr.length;
        while((high-low)>1){
            if(arr[0]!=1) return 1;
            if(arr[size-1]!=size+1) return size+1;

            int mid = low+(high-low)/2;
            if((arr[low]-low)!=(arr[mid] - mid)) {
                //left side
                high = mid;
            } //right side
            else if((arr[high]-high)!=(arr[mid] - mid)){
                low=mid;
            }
        }
        return (arr[low]+1);
    }
    public static void main(String[] args)
    {
        MissingNumber obj = new MissingNumber();
        System.out.println(obj.missingNum(new int[]{1,3,4,5,6,7}));
        System.out.println(obj.missingNum(new int[]{2,3,4,5,6,7}));
        System.out.println(obj.missingNum(new int[]{1,2,3,4,5,6,7,8}));

    }
}

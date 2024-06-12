package mock;
//Time Complexity: O(logn)
public class findMiss {

    public int find(int arr[]){

        int low = 0;
        int high = arr.length - 1;
        int res = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(arr[mid] == mid + 1){
                low = mid + 1;
            }
            else{
                high = mid  -1;
            }

           res =  mid+1;
        }


        return res;
    }

    public static void main(String args[]){

        int arr[] = new int[]{1,3};

        findMiss ob = new findMiss();

        System.out.println("Missing element: "+ob.find(arr));
    }
}

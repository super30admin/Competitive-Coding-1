//Time Complexity O(n)
//Space Complexity O(1)
public class Problem1 {
    public static int missingElement(int a[],int size){
        int low = 0;
        int high = size-1;
        // System.out.println(size);
        if(size==0){
            return 1;
        }
        if(a[high]==size){
            return a[high]+1;
        }
        if(a[0]!=1){
            return 1;
        }


        while(high>low+1){
            int mid = low +((high-low)/2);
            if(a[low]-low != a[mid]-mid){
                high=mid;
            }
            else{
                low=mid;
            }
        }
        return a[low]+1;
    }
    public static void main(String[] args) {

        //int a[] = {1,2,3,4,5,7,8};
        // int a[] = {};
        int a[] = {2,3,4,5,6};
        int size = a.length;
        int element = missingElement(a,size);
        System.out.println(element);
    }

}
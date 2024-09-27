public class Solution{
public  int missingInt(int[] intArr){
        if(intArr==null || (intArr.length<2)) return -1;
        int low= 0;
        int high= intArr.length-1;
        while(low<=high){
            int mid= (high-low)/2+ low;
            if(high-low==1){
                return low+2;
            }
            if(intArr[mid-1]+2==intArr[mid]){
                return mid+1;
            }
            if(intArr[mid-1]==mid){
                low=mid;
            }else{
                high=mid;
            }
        }
        return -1;
    }
 
    
}

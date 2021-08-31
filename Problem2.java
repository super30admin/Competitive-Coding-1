//time complexity : LogN
//space complexity : 1
// any doubts : no
public class Problem2 {
    public static int findMissingElement(int[] arr){
        if(arr[0]!=1){
            return 1;
        }
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(mid != 0 && arr[mid]-mid==2 && arr[mid-1]-(mid-1)==1){
                return arr[mid]-1;
            }else if(mid != arr.length-1 && arr[mid]-mid==1 && arr[mid+1]-(mid+1)==2  )            {
                return arr[mid]+1;
            }
            else if(arr[mid]-mid==2){
                high = mid-1;
            }else{
                low = mid +1;
            }
        }
        return arr[arr.length-1]+1;
        
    }
    public static void main (String[] args)
{
    
    int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
   
    System.out.println("Missing number: " +
                        findMissingElement(ar));
}
}


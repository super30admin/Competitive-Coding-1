import javax.lang.model.util.ElementScanner6;

class missingelement{
    int missing(int[] arr)
    {
        int  low=0;
        int high = arr.length-1;
      
             while((high-low)>1)
              {
                  int mid=(low+high)/2;
                 
                  int midDiff=arr[mid]- mid;
                  int lowDiff= arr[low]-low;
                  if(midDiff!=lowDiff)
                      high =mid;
                      else 
                          low=mid;
              }
              return (arr[low]+arr[high])/2;
    }

    public static void main(String args[]){
    int[] arr= new int[]{3,5,6,7,8};
        missingelement obj= new missingelement();
        System.out.println(obj.missing(arr));
    }

}

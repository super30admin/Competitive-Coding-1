//Time Complexity: O(log(n))
//Space Complexity: O(1)
//Source: https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
public class Main {
    public static void main(String[] args) {
       
        int[] arr=new int[]{1,3,4,5,6};
         System.out.println(findMissingNo(arr,6));
    }
    
    public static int findMissingNo(int[] arr, int n)
    {
        int len=arr.length, l=0,r=arr.length-1,mid=0;
		//If 1st element is missing
        if(arr[0]!=1)
            return 1;
		
		//If last element is missing
        if(arr[n-2]!=n)
            return n;
		
		//Using Binary Search
        while(l<=r)
        {
            mid=l+(r-l)/2;
            
			//If the missing element is in the left half of the array
                if(arr[mid]-mid!=1)
                {
					//If the missing number is in between mid-1 and mid
                    if(mid!=0 && arr[mid-1]+2==arr[mid])
                    {
                        return arr[mid]-1;
                    }
                    else
                    {
                        r=mid-1;
                    }

                }
              else //If the missing element is in the right half of the array
              {
				  //If the missing number is in between mid and mid+1
                   if(mid!=len-1 && arr[mid]+2==arr[mid+1])
                    {
                        return arr[mid]+1;
                    }
                    else
                    {
                        l=mid+1;
                    }

              }

        }
           return -1;
    }
}

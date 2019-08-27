//The aim of this program is to find the missing element in a sorted array
//Time complexity is O(log n)
//Space Complexity is O(1)

class solution
{
    public int main(String [] args)
    {
        //Initialize any sorted Array with a missing value
        int nums[] = { 1,2,4,5,6,7,8,9 };
        missingelement(int[] nums)
    }

    private int missingelement(int[] ar)
    {
        // setting the left and right index
        int l = 0;
        size = ar.length-1;
        int r = size-1;

       //While the difference between the left and the right index is greater than 1
        while(r-l > 1)
        {
            //Calculate the mid value
            int mid = l+(r-l)/2;
            //If the difference between the left and mid indices and its corresponding values dont match
            if(mid - l != ar[mid]-ar[l])
            {
                //assign mid as the right index 
                r = mid;
            }
            //if the above condition does not match for mid and right indices and its corresponding value
            else
            {
                // the current mid as the new left index
                l = mid;
            }
            //if the difference between the left and the right indices is equal to 1
          	if(r-l ==1)
            {
              //It means we have reached an array of length 2 and the missing value is in between the 2 numbers hence return the average of the 2 numbers as the missing value.
              //System.out.println(r);
              return ((ar[r]+ar[l])/2) ;
            }
        }
        return -1;
    }
}

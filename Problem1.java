import java.io.*;
 
class GFG
{
static int search(int ar[])
{
   int start=0;
   int end = ar.length-1;
    int mid=0;
   while(start<=end){
         mid = (start+end)/2;

        if(ar[mid]==mid+1)
            start=mid+1;
        else
            end =mid-1;
   }
   if(ar[mid]==mid+1)
        return ar[mid]+1;
    else
        return ar[mid]-1;
}
 
// Driver Code
public static void main (String[] args)
{
    int ar[] = { 1, 2, 3, 5, 6,7,8 };
    System.out.println("Missing number: " +
                        search(ar));
}
}
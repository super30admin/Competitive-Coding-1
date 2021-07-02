/*
Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer. 
Examples: 

Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
Output : 5

Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
Output : 7


Time: O(N)
Space: O(1)
*/

class Search{

    static int search(int[] arr){

        //iterate through the array
        int val=1;

        for(int i: arr){
            if(i==val)val++;

            else return val;
        }
        //assuming if there's no missing value return -1//invalid case
        //since return type of this function is int this fn would definitely return something!
        return -1;


    }

    public static void main (String[] args)
{
    int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
    System.out.println("Missing number: " +
                        search(ar));
}
 
}

*************** O(LOG N) ****************************************
public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        
        int[] arr= {1,2,3,5,6}; //6 elements// (7-1)elements
        
                      //    l   r
                      //1,3,4,5,6 mid=2 
        int mid=0;
        int l=0, r=arr.length-1;
        while(l<=r){
            
            mid= l+(r-l)/2;
            
            int curr= mid+1;
            
            if(curr==arr[mid]){
                l=mid+1;
            }
            else r=mid-1;
        
        }
        
        System.out.println(mid+1);
     }
}

// To find the missing number in a sorted array
//TC is O(logn)
//SC is O(1).

//Since the array is sorted I explored BS approach. I tried to get the hold of the window in which 
//the missing element could be based on below condition 
//"index + some constant = arr[index]"
//check the above condition at mid and move low,high accordingly
//once the low,high,mid is tabularised you'll see a pattern in which missed element is always loww+1

//Executed on Linkedin: Yes


// "static void main" must be defined in a public class.
public class Problem1 {
    
    public int findMiss(int[] arr)
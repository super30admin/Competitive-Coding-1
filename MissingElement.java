// Time Complexity : O(logn) ; 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : NO

public class MissingElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,8};
        findMissingElement(arr);
        int[] arr1 = {1,3};
        findMissingElement(arr1);
        int[] arr2 = {-1,1,2,3};
        findMissingElement(arr2);
        int[] arr3 = {-2,-1,0,1,2,4};
        findMissingElement(arr3);
    }
    
    public static void findMissingElement(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int midIndex;
        int expectedEle = arr[start];
        int result = 0;

        //Iterator as long as start is less than or equal to end
        while(start <= end ){
            //Calculated Mid Index
            midIndex = start + (end - start)/2;
            //Based on the start element, we are calculating mid index element
            expectedEle = expectedEle + (midIndex - start);
            //Comparing expected mid element with the actual mid value
            if(arr[midIndex] == expectedEle){
                //If it is equal, there is no missing element in left side to  the mid element
                start = midIndex + 1;
                expectedEle += 1;
            }
            else{
                //If it is not equal, there is a missing element in left side to  the mid element
                end = midIndex - 1;
                result = expectedEle;
            }
        }
        System.out.println("Missing Element: " + result);
    }
}
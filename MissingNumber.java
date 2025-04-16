/**
 * 
Given a sorted array arr[] of n-1 integers, these integers are in the range of 1 to n. There are no duplicates in the array. One of the integers is missing in the array. Write an efficient code to find the missing integer. 
Examples: 

Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
Output : 5
Explanation: The missing integer in the above array is 5 


Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
Output : 7
Explanation: The missing integer in the above array is 7 
 */

 public class MissingNumber{
    public int FindMissingNumber(int [] nums){
        int n = nums.length;
        int SumOfNNumbers = n*(n-1)/2;
        int givenSum = 0;
        for(int num: nums){
            givenSum+= num;
        }
    return SumOfNNumbers - givenSum;
    }
 }
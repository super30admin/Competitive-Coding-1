// A binary search based program to find the
// only missing number in a sorted array of
// distinct elements within limited range.

//Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Geeksforgeeks
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The element at the ith index should be i+1;
// Binary Search can be used. Calculate the mid and check if it is equal to i+1, in that case the missing element is to the right
// Else it is on the left
// If low crosses high, return low+1 as low will be pointing to the index where the missing element is supposed to be.


#include <iostream>
using namespace std;

int search(int nums[], int size)
{
       int l=0; int h=size-1;
       while(l<=h){
           int mid = l+(h-l)/2;
           if(nums[mid] == mid+1){
               l = mid+1;
           }
           else{
               h=mid-1;
           }
       }
       return l+1;

    
}

int main()
{
    int nums[] = { 1, 2, 3, 4, 5, 6, 8 };
    int size = sizeof(nums) / sizeof(nums[0]);
    cout << "Missing number:" << search(nums, size);
}


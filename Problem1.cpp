/*The algorithm uses binary search to efficiently find the missing number in a sorted array.
At each step, it compares the value at the middle index with the expected value if no numbers were missing.
Based on this comparison, it narrows down the search space to the left or right half, ultimately finding the missing number.
Time Complexity: O(log N) 
Space Complexity: O(1)*/
#include<bits/stdc++.h>
using namespace std;
int findMissingNumber(vector<int>& nums) {
    int left=0, right=nums.sise()-1;
    while(left<=right){
        int mid=left+(right-left)/2;
        if(nums[mid]==mid+1){
            left=mid+1;
        }else{
            right=mid-1;
        }
    }
    return left+1;
}

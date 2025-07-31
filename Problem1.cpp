#include<iostream>
#include<vector>
using namespace std;
/*
-Using binary search, check the difference in the value and index
-once we identify the index where the difference is not equal to
-we return that element subtracte by 1
*/
int missingElement(vector<int>& nums){
    if(nums[0]!=1) return 1;
    int low=0,high=nums.size()-1;
    while(low<=high){
        int mid=low+(high-low)/2;
        if(nums[mid]!=mid+1){
            if(nums[mid-1]==mid) return nums[mid]-1;
            else high=mid;
        }else low=mid;
    }
    return nums[low]-1;
}
int main(){
    vector<int> nums={1,2,3,5,6,7,8};
    cout<< missingElement(nums); 
    return 0;
}

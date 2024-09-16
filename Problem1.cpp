#include<iostream>
#include<vector>
using namespace std;

class Solution{
    public:

    int missing_num(vector<int>nums){
    //If arraysize is 0 or 1 returning 1;
    if(nums.size() < 2)return 1;
    int l = 0;
    int r = nums.size()-1;
    if(nums.size() == nums[r])return -1;//No missing number return -1;
    while(l < r){
        int mid = l + (r-l)/2;
        if(nums[mid]-mid == nums[l]-l) l = mid+1;
        if(nums[mid]-mid == nums[r]-r) r = mid;
    }
    return nums[r]-1;
    }


};


int main(){

Solution obj;
vector<int>nums = {1,3};
cout << obj.missing_num(nums);



}

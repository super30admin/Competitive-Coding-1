//
// Created by shazmaan on 7/8/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution{
public:
    int problem(vector<int>& nums){
        int low = 0; int high = nums.size()-1; int mid;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid]!=(mid+1) && nums[mid-1]==mid){
                return mid+1;
            }else if(nums[mid]== mid+1){
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
};

int main(){
    Solution s;
    return 0;
}
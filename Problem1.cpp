#include<vector>
#include<bits/stdc++.h>
#include<stdlib.h>
#include<cmath>
#include<time.h>
//#include "Design1_Hashmap.cpp"

using namespace std; 

class Solution{
    public:
    int missingElement(vector<int>& nums){

        int length=nums.size();
        int low=0;
        int high=length-1;
        int mid=0;

        //if(nums.empty()) return 1;
        while(high-low >= 2) {
            mid=low+(high-low)/2;
            int midIdxDiff=nums[mid]-mid;
            int lowIdxDiff=nums[low]-low;
            int highIdxDiff=nums[high]-high;
            if(midIdxDiff != lowIdxDiff){

            high=mid;

        }else if (midIdxDiff != highIdxDiff){
            low=mid;
        }
        }
        
        return (nums[low] + nums[high])/2;

    }
};

int main(){
    Solution a;
    vector<int> nums= {1,2 ,3 ,4,6};
    int answer=a.missingElement(nums);
    cout<<answer;
}


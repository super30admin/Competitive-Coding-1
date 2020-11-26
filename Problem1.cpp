#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int main()
{
    int missing = 0;
    vector <int> nums{1,2,4,5,6,7,8,9};
    //for (int x : nums)
    //    cout << x << " ";
    int l = 0;
    int m;
    int h = nums.size()-1;
    while(l<=h){
        m = l + (h-l)/2;
        if((nums[m]-nums[l])==(m-l) && (nums[h]-nums[m])!=(h-m)){
            if(h-l!=1){
                l = m;
            }
            if(h-l==1){
                cout<<nums[h]-1;
                break;
            }
        }
        else if((nums[h]-nums[m])==(h-m) &&(nums[m]-nums[l])!=(m-l)){
            if(h-l!=1){
                h = m;
            }
            if(h-l==1){
                cout<<nums[h]-1;
                break;
            }
        }
        else{
            if(nums.size()==1){
                if(nums[0]==2){
                    cout<<1;
                    break;
                }
            }
            cout<<nums[nums.size()-1]+1;
            break;
        }
    }
    //return 0;
}

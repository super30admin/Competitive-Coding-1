/*

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
the middle condition is important to check if it in itself if the missing value.

// Your code here along with comments explaining your approach
We will take a middle pointer in the sub array and check if the difference between 
values at mid and low is equal to the index, if equal then move on to next subtree,
else remain in the same subtree and iterate the above process to find the missing value.

for every middle pointer check if the difference between its left and right counter part
is same and then proceed to other subtrees, else the missing value is either to the left
or right.

*/




#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char const *argv[])
{
    vector<int> arr{2,3,5,6};
    int high {static_cast<int> (arr.size())-1};
    int low{0};
    int mid{low +(high - low)/2};

    while(low<=high){
        
        if(arr[mid] - arr[low] > mid - low){
            if(arr[mid]-arr[mid-1] == 1 && arr[mid]-arr[mid+1]==1){
                high = mid - 1;
            }
            else{
                if((arr[mid]-arr[low])>(mid-low)){
                    cout<<arr[mid]-1;
                    break;
                }
                else{
                    cout<<arr[mid]+1;
                    break;
                }
            }
        }
        else {
           if(arr[mid]-arr[mid-1] == 1 && arr[mid]-arr[mid+1]==1){
                low = mid + 1;
            }
            else{
                if((arr[mid]-arr[low])>(mid-low)){
                    cout<<arr[mid]-1;
                    break;
                }
                else{
                    cout<<arr[mid]+1;
                    break;
                }
            }
        }

    }
    return 0;
}


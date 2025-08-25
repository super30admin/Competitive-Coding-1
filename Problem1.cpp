// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Here, the value at a particular index should be equal to index + 1, i.e, arr[index] = index + 1.
// We can use this condition to figure out where the mismatch is happening, essentially finding the missing element.
// We check if arr[mid] == mid + 1, if this is true, we move to the right half, else we move to the left half.

#include <vector>
#include <iostream>
using namespace std;

class Solution {
  public:
    int missingNumber(vector<int>& arr) {
        int low = 0;
        int high = arr.size() - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == mid + 1){ // mismatch hasn't happened yet @ mid, move to the right half and reject the left half
                low = mid + 1;
            } else{ // move to the left half and reject the right half
                high = mid - 1;
            }
        }
        return low + 1; // the index where low crosses over high is the problematic index and the missing value is low + 1
    }
};

int main() {
    Solution solution;
    vector<int> arr = {1,2,4,5,6}; // 3 missing
    cout<<"Missing: "<<solution.missingNumber(arr)<<endl;
    arr = {2}; // 1 missing
    cout<<"Missing: "<<solution.missingNumber(arr)<<endl;
    return 0;
}
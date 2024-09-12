// Time Complexity : o(log(n))
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

int bs(vector<int> &arr) {
    int low = 0;
    int high = arr.size()-1;
    while(low <= high) {
        int middle = low + (high - low)/2;
        int diff = arr[middle] - middle;
        if(diff == 1) {
            low = middle+1;
        } else {
            high = middle-1;
        }
    }
    //no missing elements
    if(low == arr.size()) {
        return -1;
    }
    return low+1;
}

int main() {
    vector<int> arr = {1,2,3,4,6,7,8};
    int missing = bs(arr);
    cout << missing << endl;
}







/* Problem Definition: In an array with values starting from 1 to n with no duplicates, find the missing number */


# include<bits/stdc++.h>

using namespace std;

int find_missing(vector<int> a){
    int low = 0, high = a.size()-1;
    while(low <= high){
        int mid = low + (high - low)/2;
        if(a[mid]-mid > 1){
            high = mid -1;
        }
        else {
            low = mid + 1;
        }
    }
    return low+1;
}

int main() {
    vector<int> a = {1, 2, 3, 4, 5, 6, 7};
    cout<<find_missing(a);
    return 0;
}

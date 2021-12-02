#include <iostream>
using namespace std;
#include "vector"
// Here the time complexity is O(logn) because fo binary search
// The Space complexity is O(1)

int search(vector<int> v){
    int low = 0;//0
    int high = v.size()-1;//6
    int mid = 0;//3


    while(high-low >1){
        mid = low + (high-low)/2;

        if((v[low]- low) != (v[mid] - mid)){
            high = mid;
        }else if((v[mid] - mid) != (v[high] - high)){
            low = mid;
        }
    }
    return (v[low] + v[high])/2;
}

int main()
{
    vector<int> v { 1, 2, 3, 4, 5, 6, 8 };
    cout << "Missing number:" << search(v);
}
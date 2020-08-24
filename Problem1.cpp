// Example program
#include <iostream>
#include <string>
#include <vector>
using namespace std;

int bSearch(vector<int> arr, int low, int high){
	while(low<=high){
	if(low == high) return low+1;
	int mid = low + (high-low)/2;
		if(mid+1!=arr[mid]){
			if(mid+1<arr[mid]){
				high = mid;
			}else{
				low = mid+1;
			}
		}else{
			low = mid+1;
		}
	}
	return -1;
}

int main(){
	vector<int> arr = {2,3,4,5,6,7,8};
	cout<<bSearch(arr, 0, arr.size()-1);
}

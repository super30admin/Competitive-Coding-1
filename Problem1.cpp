//time complexity : logn
//space complexity : o(1)

#include <iostream>
#include<vector>
using namespace std;

int main() {
	// your code goes here
	
	vector<int>v = {1,2,3,4,5,7};
	int n = v.size();
	int l = 0;
	int h =  n-1;
	while(h-l >=  2) {
		
		int mid = l + (h -l)/2;
		
		int low = v[l] - l;
		int high = v[h] - h;
		int midd = v[mid]  -mid;
		
		if(low != midd) {
			h = mid;
		} else {
			l = mid;
		}
	}
	cout<<(v[l] +v[h])/2;
	
	return 0;
}
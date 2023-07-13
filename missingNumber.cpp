#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> nums = {1, 2, 3, 4, 6, 7, 8};
	
	int low = 0;
	int high = nums.size()-1;
	int mid = (low+high)/2;
	
	if(nums[0]!=1){
	    cout << 1 <<endl;
	}
	
	if(nums[high]!=nums.size()+1){
	   cout<< nums.size()+1;
	    
	    
	}
	
	while(low<=high){
	    
	    if(nums[mid]-mid>1){
	        high = mid-1;
	         mid = (low+high)/2;
	    }
	    else{
	        low=mid+1;
	         mid = (low+high)/2;
	    }
	   
	    
	    
	}
	
	cout << nums[low]-1;
}

//time complexity: O(logn)
//space complexity:O(1)
//approach: using binary search
//solved on leetcode? no
//problem faced? yes, with the indices.
#include <iostream> 
using namespace std; 

int search(int ar[], int size) 
{ 
	int l=0;
  	int r=size-1;
  	while(l<r)
    {
      int mid=l+(r-l)/2;
      if(ar[mid]==mid+1)
      {
        l=mid+1;
      }
      else
      {
        r=mid;
      }
    }
  	return l+1;
} 

int main() 
{ 
	int ar[] = { 1, 2, 3, 4, 5, 6, 8 }; 
	int size = sizeof(ar) / sizeof(ar[0]); 
	cout << "Missing number:" << search(ar, size); 
} 


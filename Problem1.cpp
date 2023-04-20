// Time complexity: O(log(n))
// Space Complexity: O(1)

// Main idea is to observe that ar[i] = i + 1 and proceed with Binary search




#include <iostream>
using namespace std;

int search(int ar[], int size)
{
  if(ar==nullptr || size==0) return -1;
  int lo =0,hi = size - 1;
  int ans=-1;
  while(lo<=hi)
  {
    int mid = lo + (hi-lo)/2;
    if(ar[mid]==mid + 1)
    {
      lo = mid + 1;
    }
    else 
    {
      hi = mid - 1;
      ans = mid + 1;
    }
  }
  return ans;
}

int main()
{
	int ar[] = { 1, 2, 3, 4, 5, 6, 8 };
	int size = sizeof(ar) / sizeof(ar[0]);
	cout << "Missing number:" << search(ar, size);
}



#include <iostream>
#include<vector>
using namespace std;

int main() {
    int k;
	vector<int>a={22,23,24,25,26,28,29};
	int n=a.size();
	int l=0,h=a.size()-1;
	while(l<=h)
	{
	    int mid=l+(h-l)/2;
	    if(a[mid+1]-a[mid]>1)
	    {
	        k=a[mid]+1;
	        break;
	    }
	    else if(a[mid]-a[mid-1]>1)
	    {
	        k=a[mid]-1;
	        break;
	    }
	    else
	    {
	        if(n%2!=0)
	        {
	            if(a[h]-a[mid]>a[mid]-a[l])
	                l=mid+1;
	            else
	                h=mid-1;
	        }
	        else
	        {
	            if(a[h]-a[mid]==a[mid]-a[l])
	                h=mid-1;
	            else
	                l=mid+1;
	        }
	    }
	}
	cout<<k;
	return 0;
}

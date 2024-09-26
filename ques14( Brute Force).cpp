#include <iostream>
#include<vector>
using namespace std;

int main() {
    int k;
	vector<int>a={1,3,4,5};
	for(int i=0;i<a.size()-1;i++)
	{
	    int j=i+1;
	    if(a[j]-a[i]>1)
	    {
	         k=a[i]+1;
	         break;
	    }
	}
	cout<<k;
	return 0;
}

#include <iostream>
#include <vector>

using namespace std;

/*
Works on all edge cases (when array doesn't start from 1)

Complexity: O(logn)
*/

class Solution {
    public:
        int Search(vector<int>arr)
        {
            int start = 0;
            int end = arr.size() - 1;
            int middle;
            
            while(start <= end)
            {   
                middle = start + (end - start)/2;
                if(arr[middle] == middle + arr[0])
                {
                    if(arr[middle + 1] == middle + arr[1])
                        start = middle+1;
                    else
                        return middle + arr[1]; 
                }
        
                else 
                {
                    if(arr[middle - 1] == middle + arr[0])
                        end = middle -1;
                    else
                        return middle + arr[0];
                }
            }
            return -1;
        }
};

int main() {
	Solution s;
	vector<int>vec{21,22,24,25,26};
	cout<<s.Search(vec);
	return 0;
}

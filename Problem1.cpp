/*
This program finds the missing number using binary search.

Problems with the code: Code executed, but did not return answer
*/


#include<bits/stdc++.h>
#include<vector>

using namespace std;

class Problem1
{
public:
    
    int elementFind(vector<int> vect)
    {
        int low = 0;
        int high = vect.size() - 1;
        int mid;
        //Checking if missing element is at first location
        if(vect[low] != 1)
            return 1;
        //Checking if last location has a mismatch
        else if(vect[high] != high+1)
        {    
            while(low <= high)
            {   
                mid = low + (high - low)/2;
                //Checking middle element for mismatch. If no mismatch then we search upper half
                if(vect[mid] == mid+1)
                    low = mid+1;

                else
                {   //Checking if element at the middle is the mismatch. If not then we search lower half
                    if(vect[mid-1] == mid)
                        return vect[mid]-1;

                    high = mid-1;
                }
            }
        }

    }
};

int main()
{
    Problem1 problem;
    vector<int> vect{1,2,3,4,6,7,8,9};
    problem.elementFind(vect);

    return 0;
}












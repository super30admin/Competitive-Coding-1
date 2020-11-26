// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Did not check
// Any problem you faced while coding this : Learnt new

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int main()
{
    vector<int>a = {4,56,3,7,98,32,4,13,59,0,6,9,2,1,5};
    priority_queue<int> pq;
    for(int i =0;i<a.size();i++){
        pq.push((-1)*a[i]);
    }
    while(!pq.empty()){
        cout<<pq.top()*-1<<endl;
        pq.pop();
    }
    return 0;
}

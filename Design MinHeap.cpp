/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <bits/stdc++.h>
using namespace std;


struct Heap{
  vector<int> v;
  
  void add(int a){
      v.push_back(a);
      
      int pos = v.size()-1;
      
      while(pos>0){
          int par = pos/2;
          
          if(v[pos] < v[par])  swap(v[pos],v[par]);
          pos = par;
      }
  }
  
  void heapify(){
      int curr = 0;
      while(1){
          int left = 2*curr+1;
          int right = 2*curr+2;
          int swap_idx;
          
          if(left >= v.size())  return;
          
          if(right >= v.size())  swap_idx = left;
          else  swap_idx = v[left] < v[right] ? left : right;
          
          swap(v[curr],v[swap_idx]);
          curr = swap_idx;
      }
  }
  
  int extractMin(){
      if(v.size()==0)  return -1;
      int ret = v[0];
      
      v[0] = v[v.size()-1];
      v.pop_back();
      
      heapify();
      return ret;
  }
  
  
};

int main()
{
    Heap h = Heap();
    
    h.add(9);
    h.add(15);
    h.add(22);
    h.add(5);
    h.add(7);
    h.add(20);
    

    cout<<h.extractMin()<<endl;
    cout<<h.extractMin()<<endl;
    
    h.add(55);
    h.add(2);
    
    cout<<h.extractMin()<<endl;
    cout<<h.extractMin()<<endl;
    
}

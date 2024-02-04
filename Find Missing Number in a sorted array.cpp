class Solution{
  public:
    int findMissingNumber(vector<int>& v, int n) {
        //edge case
        if(v[v.size()-1]!=n)  return n;
        
        int lo = 0, hi = v.size()-1;
        
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            
            if(v[mid] <= mid+1)  lo = mid+1;
            else  hi = mid;
        }
        
        return v[lo]-1;
    }
};

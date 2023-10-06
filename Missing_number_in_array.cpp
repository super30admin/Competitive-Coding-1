
class Solution{
  public:
    int missingNumber(vector<int>& a, int n) {
        // Your code goes here
        sort(a.begin(), a.end());
        int low=0;
        int high=a.size()-1;
        if(a[0]!=1)return 1;
        if(a[a.size()-1]!=n)return n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(a[mid]==mid+2){
                if(mid>0 && a[mid]-a[mid-1]==2){
                    return a[mid]-1; 
                }
                else{
                    high = mid-1;
                }
            }
            
            else {
                if(mid<a.size())
                low = mid+1;
            }
        }
    
        return -1;
    }
};

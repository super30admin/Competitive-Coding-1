//Interview Problem: Find Missing Number in a sorted array
//TC: O(logn) SC: O(1)
//We will calulate the sum of the array and subtract it form the total sum tilln

int MissingNo(const vector<int>& nums){
   int n  =nums.size();
   int sum = n(n+1)/2;
   int nsum =0;
   for(int i =0;i<n;i++){
     nsum+=nums[i];
   }
   return nsum-sum;
}
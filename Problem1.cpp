class Solution {
public:
    int missingNumber(vector<int>& nums) 
    {
        int missingNum = 0;
        for(int i=0; i < nums.size(); i++)
            missingNum ^= (nums[i] ^ i);
        
        return missingNum ^ nums.size();
    }
};


